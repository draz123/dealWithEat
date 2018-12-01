package com.yummy.transaction.model;

import com.yummy.commons.Response;
import lombok.Data;

import java.util.List;

@Data
public class BalanceResponse extends Response {

    private OrdersSummary ordersSummary;
    private List<Takings> takings;

}
