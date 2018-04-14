package com.dwe.dealwitheat.offer.model;

import javax.persistence.*;

@Entity(name = "offer")
public class OfferEntity {

    @Id
    @SequenceGenerator(name = "offer_sequence", sequenceName = "public.offer_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_sequence")
    private Integer id;
    private int restaurantId;
    private String description;
    private double price;
    private int discount;
    private int count;
    private String image;

    public OfferEntity() {
    }

    public OfferEntity(int restaurantId, String description, int price, int discount, int count, String image) {
        this.restaurantId = restaurantId;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.count = count;
        this.image = image;
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
