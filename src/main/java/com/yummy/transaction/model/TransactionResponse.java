package com.yummy.transaction.model;

import com.yummy.commons.Response;
import lombok.Data;

@Data
public class TransactionResponse extends Response {

    private String paymentCode;
    private long orderId;

}
