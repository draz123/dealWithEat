package com.yummy.transaction.db;

import com.yummy.transaction.model.TransactionEntity;
import com.yummy.transaction.model.TransactionState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, String> {

    List<TransactionEntity> findAllByTransactionState(TransactionState state);

    List<TransactionEntity> findAllByIdIn(List<Long> idList);


}
