package com.yummy.offer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "offer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferEntity {

    @Id
    @SequenceGenerator(name = "offer_sequence", sequenceName = "public.offer_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_sequence")
    private long id;
    private long restaurantId;
    private String name;
    private String description;
    private double price;
    private int discount;
    private int count;
    private String image;
    private LocalDateTime receiveTimeStart;
    private LocalDateTime receiveTimeEnd;
    private String availabilityState;


    public OfferEntity(long restaurantId, String name, String description, int price, int discount, int count, String image,
                       LocalDateTime receiveTimeStart, LocalDateTime receiveTimeEnd, String availabilityState) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.count = count;
        this.image = image;
        this.receiveTimeStart = receiveTimeStart;
        this.receiveTimeEnd = receiveTimeEnd;
        this.availabilityState = availabilityState;
    }
}
