package com.yummy.transaction.model;

import com.yummy.commons.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse extends Response {

    private String paymentCode;
    private long orderId;

}
