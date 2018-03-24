package com.dwe.dealwitheat.transaction.db;

import com.dwe.dealwitheat.transaction.model.TransactionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends PagingAndSortingRepository<TransactionEntity, String> {


}
