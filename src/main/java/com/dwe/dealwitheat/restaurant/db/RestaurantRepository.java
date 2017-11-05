package com.dwe.dealwitheat.restaurant.db;


import com.dwe.dealwitheat.restaurant.model.RestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends PagingAndSortingRepository<RestaurantEntity, String> {

    List<RestaurantEntity> findAll();

    Page<RestaurantEntity> findAllById(Pageable pageable, String id);

}
