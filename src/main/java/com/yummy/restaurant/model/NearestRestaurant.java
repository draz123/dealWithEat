package com.yummy.restaurant.model;

import lombok.Data;

@Data
public class NearestRestaurant extends RestaurantEntity {

    private double distance;

    public NearestRestaurant(long id, String name, String address, double latitude, double longtitude, String description, String website, String image, String openHours, double distance) {
        super(name, address, latitude, longtitude, description, website, image, openHours);
        this.distance = distance;
        this.setId(id);
    }

}
