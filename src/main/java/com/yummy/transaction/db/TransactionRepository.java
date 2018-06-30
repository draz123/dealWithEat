package com.yummy.transaction.db;

import com.yummy.transaction.model.TransactionEntity;
import com.yummy.transaction.model.TransactionEntity;
import com.yummy.transaction.model.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, String> {

    List<TransactionEntity> findAllByState(String state);

    List<TransactionEntity> findAllByIdIn(List<Long> idList);


}
