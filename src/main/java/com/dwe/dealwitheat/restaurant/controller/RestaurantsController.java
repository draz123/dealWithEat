package com.dwe.dealwitheat.restaurant.controller;

import com.dwe.dealwitheat.commons.Response;
import com.dwe.dealwitheat.restaurant.model.NearestRestaurantsRequest;
import com.dwe.dealwitheat.restaurant.model.RestaurantEditRequest;
import com.dwe.dealwitheat.restaurant.model.RestaurantResponse;
import com.dwe.dealwitheat.restaurant.service.RestaurantService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class RestaurantsController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "restaurants")
    public String getRestaurants(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        RestaurantResponse response = restaurantService.getRestaurants(
                Optional.ofNullable(page).orElse(0), Optional.ofNullable(size).orElse(1000));
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }


    @PostMapping(value = "restaurants/nearest")
    public String getNearestRestaurants(@RequestHeader(required = false) String email,
                                        @RequestBody NearestRestaurantsRequest nearestRestaurantsRequest) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Response response = restaurantService.getNearestRestaurants(nearestRestaurantsRequest);
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }

    @PostMapping(value = "restaurant")
    public String editRestaurant(@RequestHeader String email, @RequestBody RestaurantEditRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Response response = restaurantService.editRestaurant(email, request);
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
