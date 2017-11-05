package com.dwe.dealwitheat.payment.model;

import com.dwe.dealwitheat.commons.Response;

public class PaymentResponse extends Response {

    private String paymentCode;

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }
}
