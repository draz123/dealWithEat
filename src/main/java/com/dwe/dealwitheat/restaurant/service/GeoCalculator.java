package com.dwe.dealwitheat.restaurant.service;

import com.dwe.dealwitheat.restaurant.model.Coordinates;

public class GeoCalculator {

    public Double distanceFromMe(Coordinates userCoordinates, Coordinates restCoordinates) {
        double theta = userCoordinates.getLng() - restCoordinates.getLng();
        double dist = Math.sin(deg2rad(userCoordinates.getLat())) * Math.sin(deg2rad(restCoordinates.getLat())) + Math.cos(deg2rad(userCoordinates.getLat())) * Math.cos(deg2rad(restCoordinates.getLat())) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344 * 1000;
        return dist;
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

}
