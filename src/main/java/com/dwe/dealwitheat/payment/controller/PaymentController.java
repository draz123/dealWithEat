package com.dwe.dealwitheat.payment.controller;

import com.dwe.dealwitheat.payment.model.PaymentResponse;
import com.dwe.dealwitheat.payment.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "paymentCode")
    public String getAccountOpportunities(@RequestHeader int OwnerId, @RequestHeader int RestaurantId) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        PaymentResponse response = paymentService.getCode(OwnerId, RestaurantId);
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }
}