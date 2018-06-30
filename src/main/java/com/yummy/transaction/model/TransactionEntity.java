package com.yummy.transaction.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "transaction")
public class TransactionEntity {

    @Id
    @SequenceGenerator(name = "transaction_sequence", sequenceName = "public.transaction_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_sequence")
    private long id;
    private String code;
    private Date orderTime;
    private String state;
    private Date receiveTime;


    public TransactionEntity() {
    }

    public TransactionEntity(String code, Date orderTime, String state, Date receiveTime) {
        this.code = code;
        this.orderTime = orderTime;
        this.state = state;
        this.receiveTime = receiveTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }
}