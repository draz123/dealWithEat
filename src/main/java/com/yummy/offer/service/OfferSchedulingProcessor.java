package com.yummy.offer.service;

import com.yummy.offer.db.OfferRepository;
import com.yummy.offer.model.OfferEntity;
import com.yummy.offer.model.OfferState;
import com.yummy.transaction.service.TransactionSchedulingProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OfferSchedulingProcessor {


    @Autowired
    private OfferRepository offerRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionSchedulingProcessor.class);

    @Scheduled(initialDelay = 30 * 1000, fixedRate = 30 * 1000)
    public void updateOfferStates() {
        LOGGER.info("DB offers state refresh started...");
        List<OfferEntity> offersToUpdate = (List<OfferEntity>) offerRepository.findAll();
        offersToUpdate.stream()
                .filter(offerEntity -> offerEntity.getReceiveTimeEnd().toInstant().toEpochMilli() < (new Date(System.currentTimeMillis())).toInstant().toEpochMilli())
                .forEach(offerEntity -> {
                    offerEntity.setState(OfferState.MISSED.toString());
                    offerRepository.save(offerEntity);
                });
        LOGGER.info("DB offers state refreshed");
    }

}
