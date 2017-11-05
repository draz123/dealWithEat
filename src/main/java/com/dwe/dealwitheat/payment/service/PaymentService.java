package com.dwe.dealwitheat.payment.service;

import com.dwe.dealwitheat.payment.db.PaymentRepository;
import com.dwe.dealwitheat.payment.model.PaymentEntity;
import com.dwe.dealwitheat.payment.model.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentResponse getCode(int ownerId, int restaurantId) {
        String result =Long.toString(Math.abs(new Random(1000).nextLong()));
        PaymentEntity entity= new PaymentEntity(ownerId,restaurantId,result);
        paymentRepository.save(entity);
        PaymentResponse response = new PaymentResponse();
        response.setPaymentCode(result);
        response.setCode(200);
        response.setMessage("Code returned properly");
        return response;
    }
}
