package com.dwe.dealwitheat.transaction.db;

import com.dwe.dealwitheat.transaction.model.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, String> {

    List<TransactionEntity> findAllByState(String state);



}
