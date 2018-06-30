package com.yummy.transaction.db;

import com.yummy.transaction.model.TransactionOfferLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionOfferLinkRepository extends JpaRepository<TransactionOfferLinkEntity, String> {

    List<TransactionOfferLinkEntity> findAllByTransactionId(long id);

}
