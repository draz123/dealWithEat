package com.dwe.dealwitheat.transaction.model;

public class TransactionItem {

    private int offerId;
    private int count;

    public TransactionItem() {
    }

    public TransactionItem(int offerId, int count) {
        this.offerId = offerId;
        this.count = count;
    }

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
