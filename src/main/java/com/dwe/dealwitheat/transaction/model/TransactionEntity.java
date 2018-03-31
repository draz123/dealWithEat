package com.dwe.dealwitheat.transaction.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "transaction")
public class TransactionEntity {

    @Id
    @SequenceGenerator(name = "transaction_sequence", sequenceName = "yummy.transaction_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_sequence")
    private long id;
    private int offerId;
    private String code;
    private Date date;
    private int count;
    private String state;
    private Date receiveTime;


    public TransactionEntity() {
    }

    public TransactionEntity(int offerId, String code, Date date, int count, String state, Date receiveTime) {
        this.offerId = offerId;
        this.code = code;
        this.date = date;
        this.count = count;
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

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }
}