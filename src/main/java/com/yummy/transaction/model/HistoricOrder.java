package com.yummy.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricOrder implements Order {

    private int id;
    private String orderTime;
    private String receiveTime;
    private String state;
    private String paymentCode;
    private double price;
    private List<OrderItem> orderItemList;

}
