package com.yummy.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "restaurant_employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(RestaurantEmployeeCompositeKey.class)
public class RestaurantEmployeeEntity {

    @Id
    private long restaurantId;
    @Id
    private long userId;

}
