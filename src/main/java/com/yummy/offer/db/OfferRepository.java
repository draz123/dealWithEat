package com.yummy.offer.db;

import com.yummy.offer.model.OfferEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends PagingAndSortingRepository<OfferEntity, Integer> {

    Page<OfferEntity> findAllByRestaurantId(long restaurantId, Pageable pageRequest);


}
