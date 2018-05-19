package com.dwe.dealwitheat.restaurant.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant_employee")
public class RestaurantEmployeeEntity {

    @Id
    private String email;
    private int restaurantId;

    public RestaurantEmployeeEntity(String email, int restaurantId) {
        this.email = email;
        this.restaurantId = restaurantId;
    }

    public RestaurantEmployeeEntity() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
