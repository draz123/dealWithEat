package com.dwe.dealwitheat.restaurant.db;

import com.dwe.dealwitheat.restaurant.model.RestaurantEmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantEmployeeRepository extends CrudRepository<RestaurantEmployeeEntity, String> {

    RestaurantEmployeeEntity findFirstByEmail(String email);

}
