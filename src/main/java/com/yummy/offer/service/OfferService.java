package com.yummy.offer.service;

import com.yummy.commons.Response;
import com.yummy.offer.db.OfferRepository;
import com.yummy.offer.model.OfferEntity;
import com.yummy.offer.model.OfferRequest;
import com.yummy.offer.model.OfferResponse;
import com.yummy.offer.model.OfferState;
import com.yummy.restaurant.db.RestaurantEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private RestaurantEmployeeRepository restaurantEmployeeRepository;

    public OfferResponse getOffers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<OfferEntity> offers = offerRepository.findAll(pageable);
        OfferResponse response = new OfferResponse();
        response.setCode(200);
        response.setMessage("Offer list returned properly");
        response.setOffers(offers.getContent());
        return response;
    }

    public OfferResponse getOffersByEmail(String email, int page, int size) {
        OfferResponse response = new OfferResponse();
        response.setCode(200);
        response.setMessage("Offer list for restaurant returned properly");
        Pageable pageable = PageRequest.of(page, size);
        int restaurantId = restaurantEmployeeRepository.findFirstByEmail(email).getRestaurantId();
        Page<OfferEntity> offers = offerRepository.findAllByRestaurantId(restaurantId, pageable);
        response.setOffers(offers.getContent());
        return response;
    }

    public OfferResponse getOffersByRestaurantId(Integer id, int page, int size) {
        OfferResponse response = new OfferResponse();
        response.setMessage("Offer list for restaurant returned properly");
        Pageable pageable = PageRequest.of(page, size);
        Page<OfferEntity> offers = offerRepository.findAllByRestaurantId(id, pageable);
        response.setOffers(offers.getContent());
        return response;
    }

    public Response addNewOffer(OfferRequest request, String email) {
        offerRepository.save(new OfferEntity(restaurantEmployeeRepository.findFirstByEmail(email).getRestaurantId(), request.getName(), request.getDescription(),
                request.getPrice(), request.getDiscount(), request.getCount(), request.getImage(), request.getReceiveTimeStart(),
                request.getReceiveTimeEnd(), OfferState.ACTUAL.toString()));
        return new Response("New offer added", 200);
    }

    public Response deleteOffer(int id) {
        offerRepository.deleteById(id);
        return new Response("Offer removed", 200);

    }

    public Response editOffer(int id, OfferRequest request) {
        OfferEntity currentEntity = offerRepository.findById(id).get();
        currentEntity.setDescription(request.getDescription());
        currentEntity.setCount(request.getCount());
        currentEntity.setPrice(request.getPrice());
        currentEntity.setDiscount(request.getDiscount());
        currentEntity.setReceiveTimeStart(request.getReceiveTimeStart());
        currentEntity.setReceiveTimeEnd(request.getReceiveTimeEnd());
        request.setImage(request.getImage());
        offerRepository.save(currentEntity);
        return new Response("Offer updated", 200);
    }
}
