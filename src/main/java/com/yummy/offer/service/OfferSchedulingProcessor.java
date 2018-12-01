package com.yummy.offer.service;

import com.yummy.offer.db.OfferRepository;
import com.yummy.offer.model.OfferEntity;
import com.yummy.offer.model.OfferState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OfferSchedulingProcessor {


    private final OfferRepository offerRepository;


    @Autowired
    public OfferSchedulingProcessor(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Scheduled(initialDelay = 30 * 1000, fixedRate = 30 * 1000)
    public void updateOfferStates() {
        log.info("DB offers transactionState refresh started...");
        List<OfferEntity> offersToUpdate = (List<OfferEntity>) offerRepository.findAll();
        offersToUpdate.stream()
                .filter(offerEntity -> offerEntity.getReceiveTimeEnd().toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli() < (new Date(System.currentTimeMillis())).toInstant().toEpochMilli())
                .forEach(offerEntity -> {
                    offerEntity.setAvailabilityState(OfferState.MISSED.toString());
                    offerRepository.save(offerEntity);
                });
        log.info("DB offers transactionState refreshed");
    }

}
