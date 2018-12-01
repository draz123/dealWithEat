package com.yummy.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersSummary {


    private int acceptedOrders;
    private int canceledOrders;
    private int completedOrders;

}
