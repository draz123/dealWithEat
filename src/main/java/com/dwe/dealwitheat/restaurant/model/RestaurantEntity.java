package com.dwe.dealwitheat.restaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "Restaurant")
public class RestaurantEntity {


    public RestaurantEntity() {
    }

    public RestaurantEntity(String name, String address, double latitude, double longtitude, String description, String website) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.description = description;
        this.website = website;
    }

    @Id
    @SequenceGenerator(name = "restaurant_sequence", sequenceName = "batch.restaurant_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_sequence")
    private long id;

    private String name;
    private String address;
    private double latitude;
    private double longtitude;
    private String description;
    private String website;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
