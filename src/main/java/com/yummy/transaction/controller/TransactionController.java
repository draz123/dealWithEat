package com.yummy.transaction.controller;

import com.yummy.commons.Response;
import com.yummy.transaction.model.*;
import com.yummy.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(value = "transaction")
    public TransactionResponse doTransaction(@RequestBody TransactionRequest request) {
        return transactionService.getCode(request);
    }

    @GetMapping(value = "balance")
    public BalanceResponse getBalance(@RequestHeader String email) {
        return transactionService.getBalance(email);
    }

    @PostMapping(value = "orders/current")
    public OrdersResponse getCurrentOrders(@RequestHeader String email, @RequestBody PaginationRequest request) {
        return transactionService.getCurrentOrders(email, request);
    }

    @PostMapping(value = "orders/state")
    public Response changeOrdersState(@RequestHeader String email, @RequestBody ChangeOrderStateRequest request) {
        return transactionService.changeOrdersState(request);
    }

    @GetMapping(value = "orders")
    public Response getOrders(@RequestHeader String email, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        return transactionService.getAllOrdersByEmail(email, Optional.ofNullable(page).orElse(0), Optional.ofNullable(size).orElse(0));
    }

}