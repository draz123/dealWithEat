package com.yummy.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoordinatesWrapper {

    private Coordinates user;
    private Coordinates focus;

}
