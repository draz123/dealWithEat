package com.yummy.transaction.model;

import com.yummy.commons.Response;
import com.yummy.commons.Response;
import com.yummy.commons.Response;

public class TransactionResponse extends Response {

    private String paymentCode;
    private long orderId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }
}
