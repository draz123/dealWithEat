package com.dwe.dealwitheat.transaction.model;

import java.util.Date;

public class TransactionRequest {


    private int offerId;
    private int count;
    private Date receiveTimestamp;

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

    public Date getReceiveTimestamp() {
        return receiveTimestamp;
    }

    public void setReceiveTimestamp(Date receiveTimestamp) {
        this.receiveTimestamp = receiveTimestamp;
    }
}
