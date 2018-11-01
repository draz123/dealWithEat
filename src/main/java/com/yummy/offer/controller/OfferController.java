package com.yummy.offer.controller;

import com.yummy.commons.Response;
import com.yummy.offer.model.OfferRequest;
import com.yummy.offer.model.OfferResponse;
import com.yummy.offer.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OfferController {

    private OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping(value = "offers")
    public OfferResponse getOffers(@RequestHeader(required = false) String email, @RequestHeader(required = false) Integer id,
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
        return response;
    }


    @GetMapping(value = "offer/delete")
    public Response deleteOffer(@RequestParam int id) {
        return offerService.deleteOffer(id);
    }

    @PostMapping(value = "offer")
    public Response editOffer(@RequestParam(required = false) Integer id, @RequestBody OfferRequest request) {
        Response response;
        if (id == null) {
            response = offerService.addNewOffer(request);
        } else {
            response = offerService.editOffer(id, request);
        }
        return response;
    }
}
