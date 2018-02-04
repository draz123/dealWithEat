package com.dwe.dealwitheat.offer.db;

import com.dwe.dealwitheat.offer.model.OfferEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<OfferEntity,Integer>{

    Iterable<OfferEntity> findAllByRestaurantId(int restaurantId);

}
