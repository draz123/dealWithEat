package com.dwe.dealwitheat.offer.model;

import java.sql.Timestamp;

public class OfferRequest {

    private int restaurantId;
    private String name;
    private String description;
    private int price;
    private int discount;
    private int count;
    private String image;
    private Timestamp receiveTimeStart;
    private Timestamp receiveTimeEnd;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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
