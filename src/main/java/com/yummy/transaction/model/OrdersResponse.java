package com.yummy.transaction.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yummy.commons.Response;
import com.yummy.restaurant.model.RestaurantEntity;
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

    @JsonProperty(value = "restaurant")
    private RestaurantEntity restaurantEntity;
    private List<Order> currentOrderList;
    private int pageSize;
    private boolean isLastPage;
    private int page;

}
