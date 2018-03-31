package com.dwe.dealwitheat.transaction.model;

import java.util.Date;

public class CurrentOrder {

    private int id;
    private String name;
    private double price;
    private String date;
    private Date orderTime;
    private Date receiveTime;

    public CurrentOrder(int id, String name, double price, String date, Date orderTime, Date receiveTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.orderTime = orderTime;
        this.receiveTime = receiveTime;
    }

    public CurrentOrder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }
}
