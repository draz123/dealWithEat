package com.dwe.dealwitheat.transaction.db;

import com.dwe.dealwitheat.transaction.model.TransactionOfferLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionOfferLinkRepository extends JpaRepository<TransactionOfferLinkEntity, String> {


}
