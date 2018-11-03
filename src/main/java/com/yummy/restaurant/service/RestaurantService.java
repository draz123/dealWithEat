package com.yummy.restaurant.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yummy.commons.Response;
import com.yummy.restaurant.db.RestaurantEmployeeRepository;
import com.yummy.restaurant.db.RestaurantRepository;
import com.yummy.restaurant.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public Response getRestaurants(int page, int size) {
        RestaurantResponse response = new RestaurantResponse();
        Pageable pageable = PageRequest.of(page, size);
        List<RestaurantEntity> restaurantsList = restaurantRepository.findAll(pageable);
        response.setRestaurants(restaurantsList);
        response.setCode(200);
        response.setMessage("Restaurants returned properly");
        return response;
    }

    public Response getNearestRestaurants(NearestRestaurantsRequest nearestRestaurantsRequest) {
        GeoCalculator geoCalculator = new GeoCalculator();
        List<RestaurantEntity> restaurantEntityList = restaurantRepository.findAll();
        List<NearestRestaurant> sortedRestaurantList = restaurantEntityList.stream()
                .map(r -> new NearestRestaurant(r.getId(),
                        r.getName(),
                        r.getAddress(),
                        r.getLatitude(),
                        r.getLongtitude(),
                        r.getDescription(),
                        r.getWebsite(),
                        r.getImage(),
                        r.getOpenHours(),
                        geoCalculator.distanceFromMe(nearestRestaurantsRequest.getCoordinates(), new Coordinates(r.getLatitude(), r.getLongtitude())))
                )
                .sorted(Comparator.comparingDouble(NearestRestaurant::getDistance))
                .skip(nearestRestaurantsRequest.getPage() * nearestRestaurantsRequest.getSize())
                .limit(nearestRestaurantsRequest.getSize())
                .collect(Collectors.toList());

        NearestRestaurantResponse response = new NearestRestaurantResponse();
        response.setTotal(sortedRestaurantList.size());
        response.setRestaurants(sortedRestaurantList);
        return response;
    }


    public AdminInfoResponse getRestaurant(String email) {
        AdminInfoResponse response = new AdminInfoResponse();
        RestaurantEmployeeEntity employee = restaurantEmployeeRepository.findFirstByEmail(email);
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

    public RestaurantEntity getRestaurant(long id) {
        return restaurantRepository.findFirstById(id);
    }

    public Response editRestaurant(String email, RestaurantEditRequest request) {
        RestaurantEmployeeEntity employee = restaurantEmployeeRepository.findFirstByEmail(email);
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
