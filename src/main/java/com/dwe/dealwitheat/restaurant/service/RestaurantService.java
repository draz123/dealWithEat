package com.dwe.dealwitheat.restaurant.service;

import com.dwe.dealwitheat.restaurant.db.RestaurantEmployeeRepository;
import com.dwe.dealwitheat.restaurant.db.RestaurantRepository;
import com.dwe.dealwitheat.restaurant.model.AdminInfoResponse;
import com.dwe.dealwitheat.restaurant.model.RestaurantEmployeeEntity;
import com.dwe.dealwitheat.restaurant.model.RestaurantEntity;
import com.dwe.dealwitheat.restaurant.model.RestaurantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantEmployeeRepository restaurantEmployeeRepository;

    public RestaurantResponse getRestaurants() {
        RestaurantResponse response = new RestaurantResponse();
        List<RestaurantEntity> restaurantsList = restaurantRepository.findAll();
        response.setRestaurants(restaurantsList);
        response.setCode(200);
        response.setMessage("Restaurants returned properly");
        return response;
    }

    public AdminInfoResponse getRestaurant(String email) {
        AdminInfoResponse response = new AdminInfoResponse();
        RestaurantEmployeeEntity employee = restaurantEmployeeRepository.findOne(email);
        RestaurantEntity restaurant = restaurantRepository.findFirstById(employee.getRestaurantId());
        if (restaurant != null) {
            response.setAddress(restaurant.getAddress());
            response.setName(restaurant.getName());
            response.setEmail(email);
            response.setCode(200);
            response.setMessage("Success");
        } else {
            response.setCode(200);
            response.setMessage("No restaurant for requested email");
        }
        return response;
    }

}
