package com.yummy.offer.controller;

import com.yummy.commons.Response;
import com.yummy.offer.model.OfferRequest;
import com.yummy.offer.model.OfferResponse;
import com.yummy.offer.service.OfferService;
import com.yummy.commons.Response;
import com.yummy.offer.model.OfferResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yummy.commons.Response;
import com.yummy.offer.model.OfferResponse;
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
    public String getOffers(@RequestHeader(required = false) String email, @RequestHeader(required = false) Integer id,
                            @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        OfferResponse response = null;
        if (email == null || id == null) {
            response = offerService.getOffers(Optional.ofNullable(page).orElse(0), Optional.ofNullable(size).orElse(1000));
        }
        if (id != null) {
            response = offerService.getOffersByRestaurantId(id, Optional.ofNullable(page).orElse(0), Optional.ofNullable(size).orElse(1000));
        }
        if (email != null && email.contains("@restaurant")) {
            response = offerService.getOffersByEmail(email, Optional.ofNullable(page).orElse(0), Optional.ofNullable(size).orElse(1000));
        }
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }


    @GetMapping(value = "offer/delete")
    public String deleteOffer(@RequestParam int id) {
        Response response = offerService.deleteOffer(id);
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

    @PostMapping(value = "offer")
    public String editOffer(@RequestParam(required = false) Integer id, @RequestBody OfferRequest request) {
        Response response;
        if (id == null) {
            response = offerService.addNewOffer(request);
        } else {
            response = offerService.editOffer(id, request);
        }
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }
}
