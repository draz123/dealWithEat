package com.dwe.dealwitheat.transaction.model;

public class TransactionRequest {


    private int offerId;
    private int count;

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
