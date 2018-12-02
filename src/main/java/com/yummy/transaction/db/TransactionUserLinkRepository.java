package com.yummy.transaction.db;

import com.yummy.transaction.model.TransactionUserLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionUserLinkRepository extends JpaRepository<TransactionUserLinkEntity, Long> {

    List<TransactionUserLinkEntity> findAllByUserId(long userId);

    boolean existsByUserId(long userId);
}
