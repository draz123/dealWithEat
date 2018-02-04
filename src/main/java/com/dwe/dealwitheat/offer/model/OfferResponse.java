package com.dwe.dealwitheat.offer.model;

import com.dwe.dealwitheat.commons.Response;

import java.util.List;

public class OfferResponse extends Response{

    private List<OfferEntity> offers;

    public List<OfferEntity> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferEntity> offers) {
        this.offers = offers;
    }
}
