package com.yummy.transaction.service;

import com.yummy.commons.Response;
import com.yummy.offer.db.OfferRepository;
import com.yummy.offer.model.OfferEntity;
import com.yummy.offer.service.OfferService;
import com.yummy.restaurant.db.RestaurantEmployeeRepository;
import com.yummy.restaurant.db.RestaurantRepository;
import com.yummy.transaction.db.TransactionDao;
import com.yummy.transaction.db.TransactionOfferLinkRepository;
import com.yummy.transaction.db.TransactionRepository;
import com.yummy.transaction.db.TransactionUserLinkRepository;
import com.yummy.transaction.model.*;
import com.yummy.user.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.yummy.transaction.model.TransactionState.CANCELLED;
import static com.yummy.transaction.model.TransactionState.COMPLETED;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionDao transactionDao;
    private final OfferRepository offerRepository;
    private final TransactionOfferLinkRepository transactionOfferLinkRepository;
    private final SimpMessagingTemplate template;
    private final RestaurantEmployeeRepository restaurantEmployeeRepository;
    private final OfferService offerService;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final TransactionUserLinkRepository transactionUserLinkRepository;

    private static final String RESTAURANT_TOPIC = "/topic/restaurant/";

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, TransactionDao transactionDao, OfferRepository offerRepository,
                              TransactionOfferLinkRepository transactionOfferLinkRepository, SimpMessagingTemplate template, RestaurantEmployeeRepository restaurantEmployeeRepository,
                              OfferService offerService, RestaurantRepository restaurantRepository, UserRepository userRepository, TransactionUserLinkRepository transactionUserLinkRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionDao = transactionDao;
        this.offerRepository = offerRepository;
        this.transactionOfferLinkRepository = transactionOfferLinkRepository;
        this.template = template;
        this.restaurantEmployeeRepository = restaurantEmployeeRepository;
        this.offerService = offerService;
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
        this.transactionUserLinkRepository = transactionUserLinkRepository;
    }

    public Response getCode(TransactionRequest request, String email) {
        List<TransactionOfferLinkEntity> transactionOfferLinkEntityList = new ArrayList<>();
        Set<Long> restaurantsToUpdate = new HashSet<>();
        for (TransactionItem transaction : request.getTransactions()) {
            OfferEntity currentOffer = offerRepository.findById(transaction.getOfferId()).get();
            restaurantsToUpdate.add(restaurantRepository.findFirstById(currentOffer.getRestaurantId()).getId());
            int newOfferCount = currentOffer.getCount() - transaction.getCount();
            if (newOfferCount < 0) {
                return buildLackOfOffersResponse(currentOffer, newOfferCount);
            }
            TransactionOfferLinkEntity transactionOfferLinkEntity = TransactionOfferLinkEntity.builder()
                    .offerId(transaction.getOfferId())
                    .count(transaction.getCount())
                    .build();
            transactionOfferLinkEntityList.add(transactionOfferLinkEntity);
        }
        updateOffersState(restaurantsToUpdate);
        String code = generatePaymentCode();
        TransactionEntity savedEntity = saveTransaction(request, code);
        saveUserTransactionLink(email, savedEntity);
        saveOfferTransactionLink(transactionOfferLinkEntityList, savedEntity);
        return buildTransactionResponse(code, savedEntity);
    }

    private void updateOffersState(Set<Long> restaurantsToUpdate) {
        updateCurrentOrders(restaurantsToUpdate);
        updateCurrentOffers(restaurantsToUpdate);
    }

    private String generatePaymentCode() {
        return Integer.toString(ThreadLocalRandom.current().nextInt(10000, 99999));
    }

    private TransactionEntity saveTransaction(TransactionRequest request, String code) {
        return transactionRepository.save(new TransactionEntity(code, TransactionState.PENDING, null, LocalDateTime.now(), request.getReceiveTimestamp()));
    }


    private void saveOfferTransactionLink(List<TransactionOfferLinkEntity> transactionOfferLinkEntityList, TransactionEntity savedEntity) {
        transactionOfferLinkEntityList.forEach(
                t -> {
                    t.setTransactionId(savedEntity.getId());
                    transactionOfferLinkRepository.save(t);
                }
        );
    }

    private void saveUserTransactionLink(String email, TransactionEntity savedEntity) {
        transactionUserLinkRepository.save(new TransactionUserLinkEntity(userRepository.findByEmail(email).getId(), savedEntity.getId()));
    }

    private Response buildLackOfOffersResponse(OfferEntity currentOffer, int newOfferCount) {
        Response response;
        response = LackOfferStatus.builder()
                .offer(currentOffer)
                .difference(Math.abs(newOfferCount))
                .build();
        response.setMessage("Could not execute request. Request count greater than current offer count for offer" +
                " with id: " + currentOffer.getId());
        response.setCode(204);
        return response;
    }

    private void updateCurrentOffers(Set<Long> idList) {
        idList.forEach(r ->
                template.convertAndSend(RESTAURANT_TOPIC + r, offerService.getOffersByRestaurantId(r, 0, 1000))
        );

    }

    private void updateCurrentOrders(Set<Long> idList) {
        idList.forEach(r ->
                template.convertAndSend(RESTAURANT_TOPIC + r, getCurrentOrders(r, new PaginationRequest(0, 1000)))
        );

    }


    public BalanceResponse getBalance(String email) {
        BalanceResponse response = new BalanceResponse();
        long restaurantId = restaurantEmployeeRepository.findByUserId(userRepository.findByEmail(email).getId()).getRestaurantId();

        response.setOrdersSummary(getOrderSummary(restaurantId));
        response.setTakings(getTakingsSummary(restaurantId));
        response.setCode(200);
        response.setMessage("Success");
        return response;
    }

    private List<Takings> getTakingsSummary(long restaurantId) {
        List<Takings> takingsList = new ArrayList<>();
        Takings entire = new Takings(TakingsState.ENTIRE.name(),
                transactionDao.countTakings(restaurantId, TakingsState.ENTIRE.getTime()));
        Takings monthly = new Takings(TakingsState.MONTHLY.name(),
                transactionDao.countTakings(restaurantId, TakingsState.MONTHLY.getTime()));
        Takings weekly = new Takings(TakingsState.WEEKLY.name(),
                transactionDao.countTakings(restaurantId, TakingsState.WEEKLY.getTime()));
        takingsList.add(entire);
        takingsList.add(monthly);
        takingsList.add(weekly);
        return takingsList;
    }


    private OrdersSummary getOrderSummary(long restaurantId) {
        return new OrdersSummary(
                transactionDao.countAll(restaurantId),
                transactionDao.countByState(restaurantId, CANCELLED.toString()),
                transactionDao.countByState(restaurantId, COMPLETED.toString())
        );

    }

    public OrdersResponse getCurrentOrders(long restaurantId, PaginationRequest request) {
        OrdersResponse response = new OrdersResponse();
        int limit = request.getPage() == 0 ? request.getSize() : request.getPage() * request.getSize();
        int offset = request.getPage() == 0 ? 0 : request.getSize();
        List<Order> currentOrderList = transactionDao.getPendingOrdersForRestaurant(restaurantId, limit, offset);
        currentOrderList.forEach(o ->
        {
            final double[] price = {0.0};
            List<TransactionOfferLinkEntity> transactionOfferLinkEntityList = transactionOfferLinkRepository.findAllByTransactionId((long) ((CurrentOrder) o).getId());
            List<OrderItem> orderItemList = transactionOfferLinkEntityList.stream()
                    .map(t -> {
                        OfferEntity offerEntity = offerRepository.findById(t.getOfferId()).get();
                        price[0] += offerEntity.getPrice();
                        return new OrderItem(offerEntity.getId(), offerEntity.getDescription(),
                                offerEntity.getPrice(), t.getCount(), offerEntity.getDiscount(), offerEntity.getImage());
                    })
                    .collect(Collectors.toList());
            ((CurrentOrder) o).setPrice(price[0]);
            ((CurrentOrder) o).setOrderItemList(orderItemList);
        });
        response.setCurrentOrderList(currentOrderList);
        response.setMessage("Success");
        response.setCode(200);
        return response;
    }

    public Response changeOrdersState(ChangeOrderStateRequest request) {
        List<TransactionEntity> transactionsToUpdate = transactionRepository.findAllByIdIn(request.getIdList());
        transactionsToUpdate.forEach(transactionEntity -> {
            transactionEntity.setTransactionState(request.getState());
            transactionRepository.save(transactionEntity);
        });
        return new Response("Success", 200);
    }

    public Response getAllOrdersByEmail(String email, Integer page, Integer size) {
        int limit = page == 0 ? 1000 : page * size;
        int offset = page == 0 ? 0 : size;
        List<Order> historicOrders = transactionDao.findAllByRestaurant(email, limit, offset)
                .stream()
                .map(order ->
                {
                    final double[] price = {0.0};
                    List<TransactionOfferLinkEntity> transactionOfferLinkEntityList = transactionOfferLinkRepository.findAllByTransactionId((long) ((HistoricOrder) order).getId());
                    List<OrderItem> orderItemList = transactionOfferLinkEntityList.stream()
                            .map(t -> {
                                OfferEntity offerEntity = offerRepository.findById(t.getOfferId()).get();
                                price[0] += offerEntity.getPrice();
                                return new OrderItem(offerEntity.getId(), offerEntity.getDescription(),
                                        offerEntity.getPrice(), t.getCount(), offerEntity.getDiscount(), offerEntity.getImage());
                            })
                            .collect(Collectors.toList());
                    ((HistoricOrder) order).setOrderItemList(orderItemList);
                    ((HistoricOrder) order).setPrice(price[0]);
                    return order;
                })
                .sorted()
                .collect(Collectors.toList());
        OrdersResponse ordersResponse = new OrdersResponse();
        final long restaurantId = restaurantEmployeeRepository.findByUserId(userRepository.findByEmail(email).getId()).getRestaurantId();

        ordersResponse.setRestaurantEntity(restaurantRepository.findFirstById(restaurantId));
        ordersResponse.setCurrentOrderList(historicOrders);
        ordersResponse.setPage(page);
        ordersResponse.setPageSize(size);
        ordersResponse.setCode(200);
        ordersResponse.setMessage("Success");
        return ordersResponse;
    }

    private Response buildTransactionResponse(String code, TransactionEntity transactionEntity) {
        Response response = new TransactionResponse();
        ((TransactionResponse) response).setOrderId(transactionEntity.getId());
        ((TransactionResponse) response).setPaymentCode(code);
        response.setCode(200);
        response.setMessage("Code returned properly");
        return response;
    }
}
