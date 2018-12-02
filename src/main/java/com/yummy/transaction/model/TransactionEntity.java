package com.yummy.transaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    @Id
    @SequenceGenerator(name = "transaction_sequence", sequenceName = "public.transaction_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_sequence")
    private long id;
    private String code;
    @Enumerated(EnumType.STRING)
    private TransactionState transactionState;
    @Enumerated(EnumType.STRING)
    private CauseState causeState;
    private LocalDateTime orderTime;
    private LocalDateTime receiveTime;

    public TransactionEntity(String code, TransactionState transactionState, CauseState causeState, LocalDateTime orderTime, LocalDateTime receiveTime) {
        this.code = code;
        this.transactionState = transactionState;
        this.causeState = causeState;
        this.orderTime = orderTime;
        this.receiveTime = receiveTime;
    }
}