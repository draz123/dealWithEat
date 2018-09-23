package com.yummy.offer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "offer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferEntity {

    @Id
    @SequenceGenerator(name = "offer_sequence", sequenceName = "public.offer_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_sequence")
    private Integer id;
    private int restaurantId;
    private String name;
    private String description;
    private double price;
    private int discount;
    private int count;
    private String image;
    private Timestamp receiveTimeStart;
    private Timestamp receiveTimeEnd;
    private String state;

    public OfferEntity(int restaurantId, String name, String description, double price, int discount, int count, String image,
                       Timestamp receiveTimeStart, Timestamp receiveTimeEnd, String state) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.count = count;
        this.image = image;
        this.receiveTimeStart = receiveTimeStart;
        this.receiveTimeEnd = receiveTimeEnd;
        this.state = state;
    }
}
