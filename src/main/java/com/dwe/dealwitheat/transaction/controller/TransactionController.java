package com.dwe.dealwitheat.transaction.controller;

import com.dwe.dealwitheat.transaction.model.TransactionRequest;
import com.dwe.dealwitheat.transaction.model.TransactionResponse;
import com.dwe.dealwitheat.transaction.service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    TransactionService paymentService;

    @PostMapping(value = "transaction")
    public String getAccountOpportunities(@RequestBody TransactionRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TransactionResponse response = paymentService.getCode(request);
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }
}