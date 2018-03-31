package com.dwe.dealwitheat.restaurant.db;


import com.dwe.dealwitheat.restaurant.model.RestaurantEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends CrudRepository<RestaurantEntity, String> {

    List<RestaurantEntity> findAll();

    RestaurantEntity findFirstById(long id);


}
