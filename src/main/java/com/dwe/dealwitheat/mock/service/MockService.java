package com.dwe.dealwitheat.mock.service;

import com.dwe.dealwitheat.mock.model.MockResponse;
import com.dwe.dealwitheat.restaurant.db.RestaurantEmployeeRepository;
import com.dwe.dealwitheat.restaurant.model.RestaurantEmployeeEntity;
import com.dwe.dealwitheat.user.model.RequestUserParameters;
import com.dwe.dealwitheat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MockService {

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantEmployeeRepository restaurantEmployeeRepository;

    public MockResponse mockUserData() {
        userService.createNewUser(new RequestUserParameters("user1@user.com", "user1"));
        userService.createNewUser(new RequestUserParameters("user2@restaurant.com", "user2"));
        restaurantEmployeeRepository.save(new RestaurantEmployeeEntity("user2@restaurant.com", 3));
        Map<String, String> user1 = new HashMap<>();
        user1.put("user1@user.com", "user1");
        Map<String, String> user2 = new HashMap<>();
        user2.put("user2@restaurant.com", "user2");
        List<Map<String, String>> responseList = new ArrayList();
        responseList.add(user1);
        responseList.add(user2);
        return new MockResponse("Success", 200, responseList);
    }

}
