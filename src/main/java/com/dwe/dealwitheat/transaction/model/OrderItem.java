package com.dwe.dealwitheat.transaction.model;

public class OrderItem {

    private int id;
    private String name;
    private double price;
    private int count;
    private int discount;
    private String image;

    public OrderItem(int id, String name, double price, int count, int discount, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.discount = discount;
        this.image = image;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
