package com.yummy.mock.model;

import com.yummy.commons.Response;
import com.yummy.commons.Response;
import com.yummy.commons.Response;

import java.util.List;

public class TransactionMockResponse extends Response {

    public TransactionMockResponse(List<Long> transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionMockResponse(String message, int code, List<Long> transactionId) {
        super(message, code);
        this.transactionId = transactionId;
    }

    public List<Long> getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(List<Long> transactionId) {
        this.transactionId = transactionId;
    }

    private List<Long> transactionId;

}
