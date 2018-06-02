package com.dwe.dealwitheat.restaurant.model;

public class Coordinates {

    private double lng;
    private double lat;

    public Coordinates(double lat, double lng) {
        this.lng = lng;
        this.lat = lat;
    }

    public Coordinates() {
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
