package com.dwe.dealwitheat.restaurant.model;

public class NearestRestaurant extends RestaurantEntity {

    private double distance;


    public NearestRestaurant(long id, String name, String address, double latitude, double longtitude, String description, String website, String image, String openHours, double distance) {
        super(name, address, latitude, longtitude, description, website, image, openHours);
        this.distance = distance;
        this.setId(id);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
