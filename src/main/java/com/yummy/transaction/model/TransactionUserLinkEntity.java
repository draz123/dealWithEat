package com.yummy.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "transaction_user_link")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TransactionUserLinkEntity {

    @Id
    @SequenceGenerator(name = "transaction_user_link_sequence", sequenceName = "public.transaction_user_link_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_user_link_sequence")
    private long id;
    private long userId;
    private long transactionId;

    public TransactionUserLinkEntity(long userId, long transactionId) {
        this.userId = userId;
        this.transactionId = transactionId;
    }
}