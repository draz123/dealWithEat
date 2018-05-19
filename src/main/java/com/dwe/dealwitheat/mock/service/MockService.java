package com.dwe.dealwitheat.mock.service;

import com.dwe.dealwitheat.mock.model.TransactionMockResponse;
import com.dwe.dealwitheat.mock.model.UserMockResponse;
import com.dwe.dealwitheat.restaurant.db.RestaurantEmployeeRepository;
import com.dwe.dealwitheat.restaurant.model.RestaurantEmployeeEntity;
import com.dwe.dealwitheat.transaction.model.TransactionItem;
import com.dwe.dealwitheat.transaction.model.TransactionRequest;
import com.dwe.dealwitheat.transaction.service.TransactionService;
import com.dwe.dealwitheat.user.model.RequestUserParameters;
import com.dwe.dealwitheat.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MockService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private RestaurantEmployeeRepository restaurantEmployeeRepository;

    @EventListener(ApplicationReadyEvent.class)
    public UserMockResponse mockUserData() {
        userService.createNewUser(new RequestUserParameters("user1@user.com", "user1"));
        userService.createNewUser(new RequestUserParameters("user2@restaurant.com", "user2"));
        restaurantEmployeeRepository.save(new RestaurantEmployeeEntity("user2@restaurant.com", 3));
        Map<String, String> user1 = new HashMap<>();
        user1.put("user1@user.com", "user1");
        Map<String, String> user2 = new HashMap<>();
        user2.put("user2@restaurant.com", "user2");
        List<Map<String, String>> responseList = new ArrayList();
        responseList.add(user1);
        responseList.add(user2);
        LOGGER.info("Logins refreshed");
        return new UserMockResponse("Success", 200, responseList);
    }

    public TransactionMockResponse mockTransactions() {
        TransactionRequest transactionRequest1 = new TransactionRequest();
        transactionRequest1.setReceiveTimestamp(new Date(System.currentTimeMillis()));
        TransactionRequest transactionRequest2 = new TransactionRequest();
        transactionRequest2.setReceiveTimestamp(new Date(System.currentTimeMillis()));
        TransactionRequest transactionRequest3 = new TransactionRequest();
        transactionRequest3.setReceiveTimestamp(new Date(System.currentTimeMillis()));
        TransactionItem transactionItem1 = new TransactionItem(13, 1);
        TransactionItem transactionItem2 = new TransactionItem(14, 1);
        TransactionItem transactionItem3 = new TransactionItem(15, 1);
        TransactionItem transactionItem4 = new TransactionItem(16, 1);
        TransactionItem transactionItem5 = new TransactionItem(17, 1);
        TransactionItem transactionItem6 = new TransactionItem(14, 2);
        transactionRequest1.setTransactions(Arrays.asList(transactionItem1, transactionItem2));
        transactionRequest2.setTransactions(Arrays.asList(transactionItem3, transactionItem4));
        transactionRequest3.setTransactions(Arrays.asList(transactionItem5, transactionItem6));
        List<Long> ids = new ArrayList<>();
        ids.add(transactionService.getCode(transactionRequest1).getOrderId());
        ids.add(transactionService.getCode(transactionRequest2).getOrderId());
        ids.add(transactionService.getCode(transactionRequest3).getOrderId());
        return new TransactionMockResponse("Success", 200, ids);
    }

}
