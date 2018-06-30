package com.yummy.restaurant.controller;

import com.yummy.commons.Response;
import com.yummy.restaurant.model.NearestRestaurantsRequest;
import com.yummy.restaurant.model.RestaurantEditRequest;
import com.yummy.restaurant.model.RestaurantResponse;
import com.yummy.restaurant.service.RestaurantService;
import com.yummy.commons.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yummy.commons.Response;
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
