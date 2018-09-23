package com.yummy.restaurant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class RestaurantEntity {


    @Id
    @SequenceGenerator(name = "restaurant_sequence", sequenceName = "batch.restaurant_sequence", allocationSize = 1, initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_sequence")
    private long id;
    private String name;
    private String address;
    @JsonProperty("lat")
    private double latitude;
    @JsonProperty("lng")
    private double longtitude;
    private String description;
    private String website;
    private String image;
    private String openHours;

    public RestaurantEntity() {
    }

    public RestaurantEntity(String name, String address, double latitude, double longtitude, String description, String website, String image, String openHours) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.description = description;
        this.website = website;
        this.image = image;
        this.openHours = openHours;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}