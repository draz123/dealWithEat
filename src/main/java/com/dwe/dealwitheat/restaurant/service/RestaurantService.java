package com.dwe.dealwitheat.restaurant.service;

import com.dwe.dealwitheat.restaurant.db.RestaurantRepository;
import com.dwe.dealwitheat.restaurant.model.RestaurantEntity;
import com.dwe.dealwitheat.restaurant.model.RestaurantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public RestaurantResponse getRestaurants() {
        RestaurantResponse response = new RestaurantResponse();
        List<RestaurantEntity> restaurantsList = restaurantRepository.findAll();
        response.setRestaurants(restaurantsList);
        response.setCode(200);
        response.setMessage("Restaurants returned properly");
        return response;
    }
}
