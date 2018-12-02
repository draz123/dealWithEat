package com.yummy.offer.service;

import com.yummy.offer.db.OfferRepository;
import com.yummy.offer.model.OfferEntity;
import com.yummy.offer.model.OfferState;
import com.yummy.transaction.db.TransactionRepository;
import com.yummy.transaction.model.CauseState;
import com.yummy.transaction.model.TransactionEntity;
import com.yummy.transaction.model.TransactionState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class OfferSchedulingProcessor {


    private final OfferRepository offerRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public OfferSchedulingProcessor(OfferRepository offerRepository, TransactionRepository transactionRepository) {
        this.offerRepository = offerRepository;
        this.transactionRepository = transactionRepository;
    }

    @Scheduled(initialDelay = 30 * 1000, fixedRate = 30 * 1000)
    public void updateOfferStates() {
        log.info("DB offers state refresh started...");
        List<OfferEntity> offersToUpdate = offerRepository.findAllByReceiveTimeEndBefore(LocalDateTime.now());
        offersToUpdate
                .forEach(offerEntity -> {
                    offerEntity.setAvailabilityState(OfferState.EXPIRED);
                    offerRepository.save(offerEntity);
                });
        log.info("DB offers transactionState refreshed");
    }

    @Scheduled(initialDelay = 45 * 1000, fixedRate = 30 * 1000)
    public void updateTransactionStates() {
        log.info("DB transactions state refresh started...");
        List<TransactionEntity> offersToUpdate = transactionRepository.findAllByReceiveTimeBefore(LocalDateTime.now());
        offersToUpdate
                .forEach(transactionEntity -> {
                    transactionEntity.setTransactionState(TransactionState.CANCELLED);
                    transactionEntity.setCauseState(CauseState.TIMEOUT);
                    transactionRepository.save(transactionEntity);
                });
        log.info("DB transactions state refreshed");

    }

}
