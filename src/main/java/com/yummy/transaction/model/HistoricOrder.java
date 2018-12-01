package com.yummy.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricOrder implements Order, Comparable {

    private int id;
    private String orderTime;
    private String receiveTime;
    private String transactionState;
    private String paymentCode;
    private double price;
    private List<OrderItem> orderItemList;

    @Override
    public int compareTo(Object o) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return -LocalDateTime.parse(this.getOrderTime().substring(0, 19), formatter)
                .compareTo(LocalDateTime.parse(((HistoricOrder) o).getOrderTime().substring(0, 19), formatter));
    }
}
