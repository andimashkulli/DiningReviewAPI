package com.example.DiningReviewAPI.repository;

import com.example.DiningReviewAPI.model.DiningReview;
import com.example.DiningReviewAPI.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    Boolean existsByUsername(String username);
Boolean existsByZipCode(Integer zipCode);
}
