package com.dwe.dealwitheat.offer.service;

import com.dwe.dealwitheat.commons.Response;
import com.dwe.dealwitheat.offer.db.OfferRepository;
import com.dwe.dealwitheat.offer.model.OfferEntity;
import com.dwe.dealwitheat.offer.model.OfferRequest;
import com.dwe.dealwitheat.offer.model.OfferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    OfferRepository repository;

    public OfferResponse getOffers() {
        OfferResponse response = new OfferResponse();
        response.setCode(200);
        response.setMessage("Offer list returned properly");
        response.setOffers((List<OfferEntity>) repository.findAll());
        return response;
    }

    public OfferResponse getOffersByRestaurantId(Integer id) {
        OfferResponse response = new OfferResponse();
        response.setCode(200);
        response.setMessage("Offer list for restaurant returned properly");
        response.setOffers((List<OfferEntity>) repository.findAllByRestaurantId(id));
        return response;
    }

    public Response addNewOffer(OfferRequest request) {
        repository.save(new OfferEntity(request.getRestaurantId(), request.getDescription(), request.getPrice(), request.getDiscount(), request.getCount(), request.getImage()));
        return new Response("New offer added", 200);
    }

    public Response deleteOffer(int id) {
        repository.delete(id);
        return new Response("Offer removed", 200);

    }

    public Response editOffer(int id, OfferRequest request) {
        OfferEntity currentEntity = repository.findOne(id);
        currentEntity.setDescription(request.getDescription());
        currentEntity.setCount(request.getCount());
        currentEntity.setPrice(request.getPrice());
        currentEntity.setDiscount(request.getDiscount());
        request.setImage(request.getImage());
        repository.save(currentEntity);
        return new Response("Offer updated", 200);
    }
}
