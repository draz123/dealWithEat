package com.dwe.dealwitheat.transaction.controller;

import com.dwe.dealwitheat.commons.Response;
import com.dwe.dealwitheat.transaction.model.*;
import com.dwe.dealwitheat.transaction.service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    private ObjectMapper mapper;

    public TransactionController() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    @PostMapping(value = "transaction")
    public String doTransaction(@RequestBody TransactionRequest request) {
        TransactionResponse response = transactionService.getCode(request);
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

    @GetMapping(value = "balance")
    public String getBalance(@RequestHeader String email) {
        BalanceResponse response = transactionService.getBalance(email);
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

    @PostMapping(value = "orders/current")
    public String getCurrentOrders(@RequestHeader String email, @RequestBody PaginationRequest request) {
        OrdersResponse response = transactionService.getCurrentOrders(email, request);
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

    @PostMapping(value = "orders/state")
    public String changeOrdersState(@RequestHeader String email, @RequestBody ChangeOrderStateRequest request) {
        Response response = transactionService.changeOrdersState(request);
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

    @GetMapping(value = "orders")
    public String getOrders(@RequestHeader String email, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        Response response = transactionService.getAllOrdersByEmail(email, Optional.ofNullable(page).orElse(0), Optional.ofNullable(size).orElse(0));
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

}