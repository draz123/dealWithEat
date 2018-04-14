package com.dwe.dealwitheat.transaction.service;

import com.dwe.dealwitheat.commons.Response;
import com.dwe.dealwitheat.offer.db.OfferRepository;
import com.dwe.dealwitheat.offer.model.OfferEntity;
import com.dwe.dealwitheat.transaction.db.TransactionDao;
import com.dwe.dealwitheat.transaction.db.TransactionOfferLinkRepository;
import com.dwe.dealwitheat.transaction.db.TransactionRepository;
import com.dwe.dealwitheat.transaction.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.dwe.dealwitheat.transaction.model.TransactionState.CANCELED;
import static com.dwe.dealwitheat.transaction.model.TransactionState.COMPLETED;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private TransactionOfferLinkRepository transactionOfferLinkRepository;

    public TransactionResponse getCode(TransactionRequest request) {
        TransactionResponse response = new TransactionResponse();
        List<TransactionOfferLinkEntity> transactionOfferLinkEntityList = new ArrayList<>();
        for (TransactionItem transaction : request.getTransactions()) {
            OfferEntity currentOffer = offerRepository.findOne(transaction.getOfferId());
            int currentOfferCount = currentOffer.getCount() - transaction.getCount();
            if (currentOfferCount < 0) {
                response.setCode(200);
                response.setMessage("Could not execute request. Request count greater than current offer count for offer" +
                        " with id: " + currentOffer.getId());
                return response;
            }
            TransactionOfferLinkEntity transactionOfferLinkEntity = new TransactionOfferLinkEntity();
            transactionOfferLinkEntity.setOfferId(transaction.getOfferId());
            transactionOfferLinkEntity.setCount(transaction.getCount());
            transactionOfferLinkEntityList.add(transactionOfferLinkEntity);
        }
        String code = Integer.toString(ThreadLocalRandom.current().nextInt(10000, 99999));
        TransactionEntity transactionEntity = new TransactionEntity(code, new Date(System.currentTimeMillis()), TransactionState.PENDING.toString(), request.getReceiveTimestamp());
        TransactionEntity savedEntity = transactionRepository.save(transactionEntity);
        transactionOfferLinkEntityList.forEach(
                t -> {
                    t.setTransactionId(savedEntity.getId());
                    transactionOfferLinkRepository.save(t);
                }
        );
        response.setPaymentCode(code);
        response.setCode(200);
        response.setMessage("Code returned properly");
        return response;
    }


    public BalanceResponse getBalance(String account) {
        BalanceResponse response = new BalanceResponse();
        response.setOrderSummary(getOrderSummary(account));
        response.setTakings(getTakingsSummary(account));
        response.setCode(200);
        response.setMessage("Success");
        return response;
    }

    private List<Takings> getTakingsSummary(String account) {
        List<Takings> takingsList = new ArrayList<>();
        Takings entire = new Takings(TakingsState.ENTIRE.name(),
                transactionDao.countTakings(account, TakingsState.ENTIRE.getTime()));
        Takings monthly = new Takings(TakingsState.MONTHLY.name(),
                transactionDao.countTakings(account, TakingsState.MONTHLY.getTime()));
        Takings weekly = new Takings(TakingsState.WEEKLY.name(),
                transactionDao.countTakings(account, TakingsState.WEEKLY.getTime()));
        takingsList.add(entire);
        takingsList.add(monthly);
        takingsList.add(weekly);
        return takingsList;
    }


    private OrderSummary getOrderSummary(String email) {
        return new OrderSummary(
                transactionDao.countAll(email),
                transactionDao.countByState(email, CANCELED.toString()),
                transactionDao.countByState(email, COMPLETED.toString()),
                transactionDao.countByState(email, TransactionState.MISSED.toString())
        );

    }

    public OrdersResponse getCurrentOrders(String email, PaginationRequest request) {
        OrdersResponse response = new OrdersResponse();
        int limit = request.getPage() == 0 ? request.getSize() : request.getPage() * request.getSize();
        int offset = request.getPage() == 0 ? 0 : request.getSize();
        List<Order> currentOrderList = transactionDao.getPendingOrdersForRestaurant(email, limit, offset);
        response.setCurrentOrderList(currentOrderList);
        return response;
    }

    public Response changeOrdersState(ChangeOrderStateRequest request) {
        if (isValidState(request.getState())) {
            List<TransactionEntity> transactionsToUpdate = transactionRepository.findAllByIdIn(request.getIdList());
            transactionsToUpdate.forEach(transactionEntity -> {
                        transactionEntity.setState(request.getState().toUpperCase());
                        transactionRepository.save(transactionEntity);
                    }
            );
            return new Response("Success", 200);
        } else {
            return new Response("Wrong state requested", 200);
        }
    }

    private boolean isValidState(String state) {
        return state.equalsIgnoreCase(CANCELED.toString()) ||
                state.equalsIgnoreCase(COMPLETED.toString());
    }

    public Response getAllOrdersByEmail(String email, Integer page, Integer size) {
        int limit = page == 0 ? size : page * size;
        int offset = page == 0 ? 0 : size;
        List<Order> historicOrders = transactionDao.findAllByRestaurant(email, limit, offset);
        OrdersResponse ordersResponse = new OrdersResponse();
        ordersResponse.setCurrentOrderList(historicOrders);
        ordersResponse.setPage(page);
        ordersResponse.setPageSize(size);
        ordersResponse.setCode(200);
        ordersResponse.setMessage("Success");
        return ordersResponse;
    }
}
