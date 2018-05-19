package com.dwe.dealwitheat.restaurant.service;

import com.dwe.dealwitheat.commons.Response;
import com.dwe.dealwitheat.restaurant.db.RestaurantEmployeeRepository;
import com.dwe.dealwitheat.restaurant.db.RestaurantRepository;
import com.dwe.dealwitheat.restaurant.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantEmployeeRepository restaurantEmployeeRepository;

    private ObjectMapper mapper;

    public RestaurantService() {
        this.mapper = new ObjectMapper();
    }

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
            try {
                response.setOpenHours(mapper.readValue(restaurant.getOpenHours(), RestaurantOpenHours.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.setMessage("Success");
        } else {
            response.setCode(200);
            response.setMessage("No restaurant for requested email");
        }
        return response;
    }

    public Response editRestaurant(String email, RestaurantEditRequest request) {
        RestaurantEmployeeEntity employee = restaurantEmployeeRepository.findOne(email);
        RestaurantEntity restaurant = restaurantRepository.findFirstById(employee.getRestaurantId());
        restaurant.setDescription(request.getDescription());
        restaurant.setImage(request.getImage());
        restaurant.setWebsite(request.getWebsite());
        try {
            restaurant.setOpenHours(mapper.writeValueAsString(request.getRestaurantOpenHours()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        restaurantRepository.save(restaurant);
        return new Response("Success", 200);
    }
}
