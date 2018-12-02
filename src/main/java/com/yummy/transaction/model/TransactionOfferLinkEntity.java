package com.yummy.transaction.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "transaction_offer_link")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TransactionOfferLinkEntity {

    @Id
    @SequenceGenerator(name = "transaction_offer_link_sequence", sequenceName = "public.transaction_offer_link_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_offer_link_sequence")
    private long id;
    private long transactionId;
    private long offerId;
    private int count;

}
