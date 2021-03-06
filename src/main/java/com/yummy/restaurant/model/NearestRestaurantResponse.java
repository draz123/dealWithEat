package com.yummy.restaurant.model;

import com.yummy.commons.Response;
import com.yummy.commons.Response;
import com.yummy.commons.Response;

import java.util.List;

public class NearestRestaurantResponse extends Response {

    private int total;
    private List<NearestRestaurant> restaurants;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<NearestRestaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<NearestRestaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
