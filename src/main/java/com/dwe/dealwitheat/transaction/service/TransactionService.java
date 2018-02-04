package com.dwe.dealwitheat.transaction.service;

import com.dwe.dealwitheat.offer.db.OfferRepository;
import com.dwe.dealwitheat.offer.model.OfferEntity;
import com.dwe.dealwitheat.transaction.db.TransactionRepository;
import com.dwe.dealwitheat.transaction.model.TransactionEntity;
import com.dwe.dealwitheat.transaction.model.TransactionRequest;
import com.dwe.dealwitheat.transaction.model.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private OfferRepository offerRepository;

    public TransactionResponse getCode(TransactionRequest request) {
        String code = Integer.toString(ThreadLocalRandom.current().nextInt(10000, 99999));
        TransactionEntity entity = new TransactionEntity(request.getOfferId(), code, new Date(System.currentTimeMillis()), request.getCount());
        transactionRepository.save(entity);
        OfferEntity currentOffer = offerRepository.findOne(request.getOfferId());
        int currentOfferCount = currentOffer.getCount() - request.getCount();
        TransactionResponse response = new TransactionResponse();
        if (currentOfferCount < 0) {
            response.setCode(200);
            response.setMessage("Could not execute request. Request count greater than current offer count");
            return response;
        } else {
            currentOffer.setCount(currentOfferCount);
            offerRepository.save(currentOffer);
            response.setPaymentCode(code);
            response.setCode(200);
            response.setMessage("Code returned properly");
            return response;
        }
    }
}
