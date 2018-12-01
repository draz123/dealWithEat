package com.yummy.transaction.service;

import com.yummy.transaction.db.TransactionRepository;
import com.yummy.transaction.model.TransactionEntity;
import com.yummy.transaction.model.TransactionState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

@Service
@Slf4j
public class TransactionSchedulingProcessor {


    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionSchedulingProcessor(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Scheduled(fixedRate = 30 * 1000)
    public void updateTransactionStates() {
        log.info("DB transaction transactionState refresh");
        List<TransactionEntity> transactionsToUpdate = transactionRepository.findAllByTransactionState(TransactionState.PENDING);
        transactionsToUpdate.stream()
                .filter(transactionEntity -> transactionEntity.getReceiveTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() < Instant.now().toEpochMilli())
                .forEach(transactionEntity -> {
                    transactionEntity.setTransactionState(TransactionState.CANCELLED);
                    transactionRepository.save(transactionEntity);
                });
    }


}
