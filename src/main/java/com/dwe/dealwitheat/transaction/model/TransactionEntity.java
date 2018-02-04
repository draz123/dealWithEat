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
    private int offerCount;

    public TransactionEntity(int offerId) {
        this.offerId = offerId;
    }

    public TransactionEntity(int offerId, String code, Date date, int offerCount) {
        this.offerId = offerId;
        this.code = code;
        this.date = date;
        this.offerCount = offerCount;
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

    public int getOfferCount() {
        return offerCount;
    }

    public void setOfferCount(int offerCount) {
        this.offerCount = offerCount;
    }
}