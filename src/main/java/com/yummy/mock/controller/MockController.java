package com.yummy.mock.controller;


import com.yummy.mock.model.TransactionMockResponse;
import com.yummy.mock.model.UserMockResponse;
import com.yummy.mock.service.MockService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

    private ObjectMapper mapper;

    public MockController() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Autowired
    private MockService mockService;

    @GetMapping(value = "mock/users")
    public String reloadUsers() {
        UserMockResponse response = mockService.mockUserData();
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

    @GetMapping(value = "mock/transactions")
    public String mockTransactions() {
        TransactionMockResponse response = mockService.mockTransactions();
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

}
