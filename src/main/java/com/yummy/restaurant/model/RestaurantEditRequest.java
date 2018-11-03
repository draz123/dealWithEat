package com.yummy.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantEditRequest {

    private String website;
    private String description;
    private String image;
    private RestaurantOpenHours restaurantOpenHours;

}
