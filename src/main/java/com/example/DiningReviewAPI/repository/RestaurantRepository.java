package com.example.DiningReviewAPI.repository;

import com.example.DiningReviewAPI.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Boolean existsByRestaurantNameAndZipCode(String restaurantName, Integer zipCode);
Boolean existsByZipCode(Integer zipCode);
List<Restaurant> findByZipCode(Integer zipCode);
Boolean existsById(Integer id);

}
