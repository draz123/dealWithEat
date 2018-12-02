package com.yummy.offer.db;

import com.yummy.offer.model.OfferEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

    Page<OfferEntity> findAllByRestaurantId(long restaurantId, Pageable pageRequest);

    List<OfferEntity> findAllByReceiveTimeEndBefore(LocalDateTime dateTime);


}
