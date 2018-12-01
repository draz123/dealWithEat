package com.yummy.offer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferRequest {

    private int restaurantId;
    private String name;
    private String description;
    private int price;
    private int discount;
    private int count;
    private String image;
    private LocalDateTime receiveTimeStart;
    private LocalDateTime receiveTimeEnd;

}
