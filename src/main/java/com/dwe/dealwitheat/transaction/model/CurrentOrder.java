package com.dwe.dealwitheat.transaction.model;

import java.util.List;

public class CurrentOrder implements Order {


    private List<OrderItem> orderItemList;

    private int id;
    private String orderTime;
    private String receiveTime;
    private String paymentCode;

    public CurrentOrder(int id, String orderTime, String receiveTime, String paymentCode) {
        this.id = id;
        this.orderTime = orderTime;
        this.receiveTime = receiveTime;
        this.paymentCode = paymentCode;
    }

    public CurrentOrder() {
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
