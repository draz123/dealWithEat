package com.yummy.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricOrder implements Order, Comparable {

    private long id;
    private LocalDateTime orderTime;
    private LocalDateTime receiveTime;
    @Enumerated(EnumType.STRING)
    private TransactionState transactionState;
    private String paymentCode;
    private double price;
    private List<OrderItem> orderItemList;

    @Override
    public int compareTo(Object o) {
        return -this.getOrderTime().compareTo(((HistoricOrder) o).getOrderTime());
    }
}
