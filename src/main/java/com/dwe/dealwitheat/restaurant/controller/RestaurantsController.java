package com.dwe.dealwitheat.restaurant.controller;

import com.dwe.dealwitheat.commons.Response;
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
    private RestaurantService restaurantService;

    @GetMapping(value = "restaurants")
    public String getRestaurants() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        RestaurantResponse response = restaurantService.getRestaurants();
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

    @GetMapping(value = "admin/info")
    public String getRestaurant(@RequestHeader String email) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Response response = restaurantService.getRestaurant(email);
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

}
