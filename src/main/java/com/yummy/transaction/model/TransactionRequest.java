package com.yummy.transaction.model;

import com.yummy.commons.Response;

import java.util.Date;
import java.util.List;

public class TransactionRequest extends Response {

    private List<TransactionItem> transactions;
    private Date receiveTimestamp;

    public Date getReceiveTimestamp() {
        return receiveTimestamp;
    }

    public void setReceiveTimestamp(Date receiveTimestamp) {
        this.receiveTimestamp = receiveTimestamp;
    }

    public List<TransactionItem> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionItem> transactions) {
        this.transactions = transactions;
    }

}
