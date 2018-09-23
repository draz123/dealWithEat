package com.yummy.transaction.model;

import com.yummy.commons.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersResponse extends Response {

    private List<Order> currentOrderList;
    private int pageSize;
    private boolean isLastPage;
    private int page;

}
