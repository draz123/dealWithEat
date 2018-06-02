package com.dwe.dealwitheat.restaurant.model;

import com.dwe.dealwitheat.commons.Response;

import java.util.List;

public class NearestRestaurantResponse extends Response {

    private List<NearestRestaurant> restaurants;

    public List<NearestRestaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<NearestRestaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
