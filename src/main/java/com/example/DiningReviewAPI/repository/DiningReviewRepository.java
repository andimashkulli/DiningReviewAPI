package com.example.DiningReviewAPI.repository;

import com.example.DiningReviewAPI.model.DiningReview;
import org.springframework.data.repository.CrudRepository;
public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {
    Boolean existsByReviewerName(String reviewerName);
}
