package com.yummy.transaction.model;

import com.yummy.commons.Response;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TransactionRequest extends Response {

    private List<TransactionItem> transactions;
    private LocalDateTime receiveTimestamp;

}
