package com.dwe.dealwitheat.restaurant.model;

import com.dwe.dealwitheat.commons.Response;

import java.util.List;

public class RestaurantResponse extends Response {

    private List<RestaurantEntity> restaurants;

    public List<RestaurantEntity> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<RestaurantEntity> restaurants) {
        this.restaurants = restaurants;
    }
}
