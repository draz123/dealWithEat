package com.dwe.dealwitheat.transaction.model;

import com.dwe.dealwitheat.commons.Response;

public class TransactionResponse extends Response {

    private String paymentCode;

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }
}
