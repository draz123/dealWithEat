package com.yummy.restaurant.model;

import com.yummy.commons.Response;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantResponse extends Response {

    private List<RestaurantEntity> restaurants;

}
