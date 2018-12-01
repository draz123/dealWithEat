package com.yummy.restaurant.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yummy.commons.Response;
import com.yummy.restaurant.db.RestaurantEmployeeRepository;
import com.yummy.restaurant.db.RestaurantRepository;
import com.yummy.restaurant.model.*;
import com.yummy.user.db.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;
    private final RestaurantEmployeeRepository restaurantEmployeeRepository;

    private ObjectMapper mapper;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, UserRepository userRepository, RestaurantEmployeeRepository restaurantEmployeeRepository) {
        this.userRepository = userRepository;
        this.mapper = new ObjectMapper();
        this.restaurantRepository = restaurantRepository;
        this.restaurantEmployeeRepository = restaurantEmployeeRepository;

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
                        geoCalculator.calculateDistanceBetweenTwoPoints(resolveCoordinates(nearestRestaurantsRequest), new Coordinates(r.getLongtitude(), r.getLatitude())))
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

    private Coordinates resolveCoordinates(NearestRestaurantsRequest nearestRestaurantsRequest) {
        return nearestRestaurantsRequest.getCoordinates().getFocus() != null ? nearestRestaurantsRequest.getCoordinates().getFocus() : nearestRestaurantsRequest.getCoordinates().getUser();
    }


    public AdminInfoResponse getRestaurant(String email) {
        AdminInfoResponse response = new AdminInfoResponse();
        RestaurantEmployeeEntity employee = restaurantEmployeeRepository.findByUserId(userRepository.findByEmail(email).getId());
        RestaurantEntity restaurant = restaurantRepository.findFirstById(employee.getRestaurantId());
        if (restaurant != null) {
            response.setAddress(restaurant.getAddress());
            response.setName(restaurant.getName());
            response.setEmail(email);
            response.setCode(200);
            try {
                response.setOpenHours(mapper.readValue(restaurant.getOpenHours(), RestaurantOpenHours.class));
            } catch (IOException e) {
                log.error(e.getMessage());
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
        RestaurantEmployeeEntity employee = restaurantEmployeeRepository.findByUserId(userRepository.findByEmail(email).getId());
        RestaurantEntity restaurant = restaurantRepository.findFirstById(employee.getRestaurantId());
        restaurant.setDescription(request.getDescription());
        restaurant.setImage(request.getImage());
        restaurant.setWebsite(request.getWebsite());
        try {
            restaurant.setOpenHours(mapper.writeValueAsString(request.getRestaurantOpenHours()));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        restaurantRepository.save(restaurant);
        return new Response("Success", 200);
    }

}
