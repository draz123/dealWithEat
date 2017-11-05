package com.dwe.dealwitheat.payment.db;

import com.dwe.dealwitheat.payment.model.PaymentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface PaymentRepository extends PagingAndSortingRepository<PaymentEntity, String> {

    @Override
    PaymentEntity save(PaymentEntity paymentEntity);

    List<PaymentEntity> findOneByUserIdAndRestaurantId(Pageable pageable, int userId, int restaurantId);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void deleteByUserIdAndRestaurantId(String userId, String restaurantId);
}
