package com.dwe.dealwitheat.restaurant.controller;

import com.dwe.dealwitheat.restaurant.model.RestaurantResponse;
import com.dwe.dealwitheat.restaurant.service.RestaurantService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestaurantsController {

    @Autowired
    RestaurantService resturantService;

    @GetMapping(value = "restaurants")
    public String getRestaurants(@RequestHeader String authorization) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        RestaurantResponse response = resturantService.getRestaurants();
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

}
