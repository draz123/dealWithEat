package com.dwe.dealwitheat.transaction.model;

import com.dwe.dealwitheat.commons.Response;

import java.util.List;

public class BalanceResponse extends Response {

    private OrderSummary orderSummary;
    private List<Takings> takings;

    public OrderSummary getOrderSummary() {
        return orderSummary;
    }

    public void setOrderSummary(OrderSummary orderSummary) {
        this.orderSummary = orderSummary;
    }

    public List<Takings> getTakings() {
        return takings;
    }

    public void setTakings(List<Takings> takings) {
        this.takings = takings;
    }
}
