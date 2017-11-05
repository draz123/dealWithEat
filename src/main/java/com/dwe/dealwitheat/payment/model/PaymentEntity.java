package com.dwe.dealwitheat.payment.model;

import javax.persistence.*;

@Entity
@Table(name = "Payment")
public class PaymentEntity {

    @Id
    @SequenceGenerator(name = "payment_sequence", sequenceName = "batch.payment_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_sequence")
    private long id;

    public PaymentEntity(int userId, int restaurantId, String code) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.code = code;
    }

    private int userId;
    private int restaurantId;
    private String code;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
