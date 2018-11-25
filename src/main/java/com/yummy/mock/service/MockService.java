package com.yummy.mock.service;

import com.yummy.mock.model.TransactionMockResponse;
import com.yummy.mock.model.UserMockResponse;
import com.yummy.transaction.model.TransactionItem;
import com.yummy.transaction.model.TransactionRequest;
import com.yummy.transaction.model.TransactionResponse;
import com.yummy.transaction.service.TransactionService;
import com.yummy.user.model.RequestUserParameters;
import com.yummy.user.service.UserService;
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

    @EventListener(ApplicationReadyEvent.class)
    public UserMockResponse mockUserData() {
        userService.createNewUser(new RequestUserParameters("user1@user.com", "user1", null));
        userService.createNewUser(new RequestUserParameters("user2@user.com", "user2", null));
        userService.createNewUser(new RequestUserParameters("user3@user.com", "user3", null));
        userService.createNewUser(new RequestUserParameters("user11@restaurant.com", "user11", 1l));
        userService.createNewUser(new RequestUserParameters("user12@restaurant.com", "user12", 2l));
        userService.createNewUser(new RequestUserParameters("user13@restaurant.com", "user13", 3l));
        userService.createNewUser(new RequestUserParameters("user14@restaurant.com", "user14", 4l));
        Map<String, String> user1 = new HashMap<>();
        user1.put("user1@user.com", "user1");
        Map<String, String> user2 = new HashMap<>();
        user2.put("user2@user.com", "user2");
        Map<String, String> user3 = new HashMap<>();
        user3.put("user3@user.com", "user3");
        Map<String, String> user11 = new HashMap<>();
        user11.put("user12@user.com", "user12");
        Map<String, String> user12 = new HashMap<>();
        user12.put("user12@user.com", "user12");
        Map<String, String> user13 = new HashMap<>();
        user13.put("user13@user.com", "user13");
        Map<String, String> user14 = new HashMap<>();
        user14.put("user14@user.com", "user14");

        List<Map<String, String>> responseList = new ArrayList();
        responseList.add(user1);
        responseList.add(user2);
        responseList.add(user3);
        responseList.add(user11);
        responseList.add(user12);
        responseList.add(user13);
        responseList.add(user14);
        LOGGER.info("Logins refreshed");
        return new UserMockResponse("Success", 200, responseList);
    }

    public TransactionMockResponse mockTransactions() {
        TransactionRequest transactionRequest1 = new TransactionRequest();
        transactionRequest1.setReceiveTimestamp(new Date(System.currentTimeMillis()));
        TransactionRequest transactionRequest2 = new TransactionRequest();
        transactionRequest2.setReceiveTimestamp(new Date(System.currentTimeMillis()));
        TransactionRequest transactionRequest3 = new TransactionRequest();
        transactionRequest3.setReceiveTimestamp(new Date(System.currentTimeMillis() + 3600 * 1000 * 4));
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
        ids.add(((TransactionResponse) transactionService.getCode(transactionRequest1)).getOrderId());
        ids.add(((TransactionResponse) transactionService.getCode(transactionRequest2)).getOrderId());
        ids.add(((TransactionResponse) transactionService.getCode(transactionRequest3)).getOrderId());
        return new TransactionMockResponse("Success", 200, ids);
    }

}
