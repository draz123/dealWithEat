package com.dwe.dealwitheat.transaction.model;


import javax.persistence.*;

@Entity(name = "transaction_offer_link")
public class TransactionOfferLinkEntity {

    @Id
    @SequenceGenerator(name = "transaction_offer_link_sequence", sequenceName = "public.transaction_offer_link_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_offer_link_sequence")
    private long id;
    private long transactionId;
    private int offerId;
    private int count;

    public TransactionOfferLinkEntity() {
    }

    public TransactionOfferLinkEntity(int transactionId, int offerId, int count) {
        this.transactionId = transactionId;
        this.offerId = offerId;
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
