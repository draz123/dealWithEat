package com.yummy.restaurant.db;


import com.yummy.restaurant.model.RestaurantEntity;
import com.yummy.restaurant.model.RestaurantEntity;
import com.yummy.restaurant.model.RestaurantEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends CrudRepository<RestaurantEntity, String> {

    List<RestaurantEntity> findAll(Pageable pageable);

    List<RestaurantEntity> findAll();

    RestaurantEntity findFirstById(long id);


}
