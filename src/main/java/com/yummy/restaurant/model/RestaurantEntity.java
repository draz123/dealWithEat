package com.yummy.restaurant.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Data
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


}
