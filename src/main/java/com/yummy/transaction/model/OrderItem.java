package com.yummy.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private int id;
    private String name;
    private double price;
    private int count;
    private int discount;
    private String image;

}
