package com.dwe.dealwitheat.transaction.model;

public class CurrentOrder implements Order {

    private int id;
    private String name;
    private double price;
    private String orderTime;
    private String receiveTime;
    private String paymentCode;

    public CurrentOrder(int id, String name, double price, String orderTime, String receiveTime, String paymentCode) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orderTime = orderTime;
        this.receiveTime = receiveTime;
        this.paymentCode = paymentCode;
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

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }
}
