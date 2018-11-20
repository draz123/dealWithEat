package com.yummy.restaurant.service;

import com.yummy.restaurant.model.Coordinates;

public class GeoCalculator {

    public double calculateDistanceBetweenTwoPoints(Coordinates userCoordinates, Coordinates restaurantCoordinates){
        double a = (userCoordinates.getLat()-restaurantCoordinates.getLat())*distPerLat(userCoordinates.getLat());
        double b = (userCoordinates.getLng()-restaurantCoordinates.getLng())*distPerLng(userCoordinates.getLat());
        return Math.sqrt(a*a+b*b);
    }

    private  double distPerLng(double lat){
        return 0.0003121092*Math.pow(lat, 4)
                +0.0101182384*Math.pow(lat, 3)
                -17.2385140059*lat*lat
                +5.5485277537*lat+111301.967182595;
    }

    private  double distPerLat(double lat){
        return -0.000000487305676*Math.pow(lat, 4)
                -0.0033668574*Math.pow(lat, 3)
                +0.4601181791*lat*lat
                -1.4558127346*lat+110579.25662316;
    }

}
