package com.yummy.restaurant.db;

import com.yummy.restaurant.model.RestaurantEmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantEmployeeRepository extends CrudRepository<RestaurantEmployeeEntity, String> {

    RestaurantEmployeeEntity findFirstByRestaurantId(long id);

    RestaurantEmployeeEntity findByUserId(long id);


}
