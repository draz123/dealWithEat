package com.yummy.transaction.service;

import com.yummy.offer.db.OfferRepository;
import com.yummy.transaction.db.TransactionRepository;
import com.yummy.transaction.model.TransactionEntity;
import com.yummy.transaction.model.TransactionState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionSchedulingProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionSchedulingProcessor.class);

    @Autowired
    private TransactionRepository transactionRepository;


    @Scheduled(fixedRate = 30 * 1000)
    public void updateTransactionStates() {
        LOGGER.info("DB transaction state refresh");
        List<TransactionEntity> transactionsToUpdate = transactionRepository.findAllByState(TransactionState.PENDING.toString());
        transactionsToUpdate.stream()
                .filter(transactionEntity -> transactionEntity.getReceiveTime().toInstant().toEpochMilli() < (new Date(System.currentTimeMillis())).toInstant().toEpochMilli())
                .forEach(transactionEntity -> {
                    transactionEntity.setState(TransactionState.MISSED.toString());
                    transactionRepository.save(transactionEntity);
                });
    }




}
