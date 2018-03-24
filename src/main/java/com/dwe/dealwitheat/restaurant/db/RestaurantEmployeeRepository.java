package com.dwe.dealwitheat.restaurant.db;

import com.dwe.dealwitheat.restaurant.model.RestaurantEmployeeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantEmployeeRepository extends PagingAndSortingRepository<RestaurantEmployeeEntity, String> {

}
