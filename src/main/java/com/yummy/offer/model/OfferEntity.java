package com.yummy.offer.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "offer")
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

    public OfferEntity() {
    }

    public OfferEntity(int restaurantId, String name, String description, int price, int discount, int count, String image,
                       Timestamp receiveTimeStart, Timestamp receiveTimeEnd, String state) {
        this.name = name;
        this.restaurantId = restaurantId;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.count = count;
        this.image = image;
        this.receiveTimeStart = receiveTimeStart;
        this.receiveTimeEnd = receiveTimeEnd;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getReceiveTimeStart() {
        return receiveTimeStart;
    }

    public void setReceiveTimeStart(Timestamp receiveTimeStart) {
        this.receiveTimeStart = receiveTimeStart;
    }

    public Timestamp getReceiveTimeEnd() {
        return receiveTimeEnd;
    }

    public void setReceiveTimeEnd(Timestamp receiveTimeEnd) {
        this.receiveTimeEnd = receiveTimeEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
