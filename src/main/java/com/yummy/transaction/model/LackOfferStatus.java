package com.yummy.transaction.model;

import com.yummy.commons.Response;
import com.yummy.offer.model.OfferEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LackOfferStatus extends Response {

    private OfferEntity offer;
    private int difference;
}
