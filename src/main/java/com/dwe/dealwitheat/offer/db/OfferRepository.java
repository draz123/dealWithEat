package com.dwe.dealwitheat.offer.db;

import com.dwe.dealwitheat.offer.model.OfferEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends PagingAndSortingRepository<OfferEntity, Integer> {

    Page<OfferEntity> findAllByRestaurantId(int restaurantId, Pageable pageRequest);


}
