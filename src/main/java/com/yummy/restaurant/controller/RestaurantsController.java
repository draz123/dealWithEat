package com.yummy.restaurant.controller;

import com.yummy.commons.Response;
import com.yummy.restaurant.model.NearestRestaurantsRequest;
import com.yummy.restaurant.model.RestaurantEditRequest;
import com.yummy.restaurant.model.RestaurantEntity;
import com.yummy.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class RestaurantsController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantsController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(value = "restaurants")
    public Response getRestaurants(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
        return restaurantService.getRestaurants(
                Optional.ofNullable(page).orElse(0), Optional.ofNullable(size).orElse(1000));
    }


    @PostMapping(value = "restaurants/nearest")
    public Response getNearestRestaurants(@RequestHeader(required = false) String email,
                                          @RequestBody NearestRestaurantsRequest nearestRestaurantsRequest) {
        return restaurantService.getNearestRestaurants(nearestRestaurantsRequest);
    }

    @PostMapping(value = "restaurant")
    public Response editRestaurant(@RequestHeader String email, @RequestBody RestaurantEditRequest request) {
        return restaurantService.editRestaurant(email, request);
    }

    @GetMapping(value = "restaurant")
    public RestaurantEntity getRestaurant(@RequestParam(name="id") long id) {
        return restaurantService.getRestaurant(id);
    }

    @GetMapping(value = "admin/info")
    public Response getRestaurant(@RequestHeader String email) {
        return restaurantService.getRestaurant(email);
    }
}
