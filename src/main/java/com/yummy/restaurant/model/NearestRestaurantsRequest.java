package com.yummy.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NearestRestaurantsRequest {


    private CoordinatesWrapper coordinates;
    private int page;
    private int size;

}
