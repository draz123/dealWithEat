package com.yummy.transaction.controller;

import com.yummy.commons.Response;
import com.yummy.restaurant.db.RestaurantEmployeeRepository;
import com.yummy.restaurant.model.RestaurantEmployeeEntity;
import com.yummy.transaction.model.*;
import com.yummy.transaction.service.TransactionService;
import com.yummy.user.db.UserRepository;
import com.yummy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TransactionController {

    private final TransactionService transactionService;
    private final RestaurantEmployeeRepository restaurantEmployeeRepository;
    private final UserRepository userRepository;

    @Autowired
    public TransactionController(TransactionService transactionService, RestaurantEmployeeRepository restaurantEmployeeRepository, UserRepository userRepository) {
        this.transactionService = transactionService;
        this.restaurantEmployeeRepository = restaurantEmployeeRepository;
        this.userRepository = userRepository;
    }

    @PostMapping(value = "transaction")
    public ResponseEntity<Response> doTransaction(@RequestHeader String email, @RequestBody TransactionRequest request) {
        return ResponseEntity.ok().body(transactionService.getCode(request, email));
    }

    @GetMapping(value = "balance")
    public BalanceResponse getBalance(@RequestHeader String email) {
        return transactionService.getBalance(email);
    }

    @PostMapping(value = "orders/current")
    public ResponseEntity<Response> getCurrentOrders(@RequestHeader String email, @RequestBody PaginationRequest request) {
        long userId = userRepository.findByEmail(email).getId();
        RestaurantEmployeeEntity restaurantEmployeeEntity = restaurantEmployeeRepository.findByUserId(userId);
        if (restaurantEmployeeEntity == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new Response("No data found for requested user", 204));
        }
        long restaurantId = restaurantEmployeeRepository.findByUserId(userId).getRestaurantId();
        return ResponseEntity.ok().body(transactionService.getCurrentOrders(restaurantId, request));
    }

    @PostMapping(value = "orders/state")
    public Response changeOrdersState(@RequestHeader String email, @RequestBody ChangeOrderStateRequest request) {
        return transactionService.changeOrdersState(request);
    }

    @GetMapping(value = "orders")
    public Response getOrders(@RequestHeader String email, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        return transactionService.getAllOrdersByEmail(email, Optional.ofNullable(page).orElse(0), Optional.ofNullable(size).orElse(10));
    }

}