package com.dwe.dealwitheat.transaction.model;

public class OrderSummary {

    private int acceptedOrders;
    private int canceledOrders;
    private int completedOrders;
    private int missedOrders;

    public OrderSummary(int acceptedOrders, int canceledOrders, int completedOrders, int missedOrders) {
        this.acceptedOrders = acceptedOrders;
        this.canceledOrders = canceledOrders;
        this.completedOrders = completedOrders;
        this.missedOrders = missedOrders;
    }

    public int getAcceptedOrders() {
        return acceptedOrders;
    }

    public void setAcceptedOrders(int acceptedOrders) {
        this.acceptedOrders = acceptedOrders;
    }

    public int getCanceledOrders() {
        return canceledOrders;
    }

    public void setCanceledOrders(int canceledOrders) {
        this.canceledOrders = canceledOrders;
    }

    public int getCompletedOrders() {
        return completedOrders;
    }

    public void setCompletedOrders(int completedOrders) {
        this.completedOrders = completedOrders;
    }

    public int getMissedOrders() {
        return missedOrders;
    }

    public void setMissedOrders(int missedOrders) {
        this.missedOrders = missedOrders;
    }

}
