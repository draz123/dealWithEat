package com.dwe.dealwitheat.offer.controller;

import com.dwe.dealwitheat.commons.Response;
import com.dwe.dealwitheat.offer.model.OfferRequest;
import com.dwe.dealwitheat.offer.model.OfferResponse;
import com.dwe.dealwitheat.offer.service.OfferService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OfferController {

    private ObjectMapper mapper;

    public OfferController() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Autowired
    private OfferService offerService;

    @GetMapping(value = "offers")
    public String getOffers(@RequestParam(required = false) Integer restaurantId, @RequestParam(required = false) Integer page,
                            @RequestParam(required = false) Integer size) {
        OfferResponse response;
        if (restaurantId == null) {
            response = offerService.getOffers(Optional.ofNullable(page).orElse(0), Optional.ofNullable(size).orElse(1000));
        } else {
            response = offerService.getOffersByRestaurantId(restaurantId, page, size);
        }
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

    @PostMapping(value = "offer")
    public String addOffer(@RequestBody OfferRequest request) {
        Response response = offerService.addNewOffer(request);
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }

    }

    @DeleteMapping(value = "offer")
    public String deleteOffer(@RequestParam int id) {
        Response response = offerService.deleteOffer(id);
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

    @PutMapping(value = "offer")
    public String editOffer(@RequestParam int id, @RequestBody OfferRequest request) {
        Response response = offerService.editOffer(id, request);
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }
}
