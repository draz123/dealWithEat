package com.yummy.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantOpenHours {

    private OpenHours week;
    private OpenHours sunday;
    private OpenHours saturday;


}
