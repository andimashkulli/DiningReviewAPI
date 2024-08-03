package com.example.DiningReviewAPI.model;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="DINING_REVIEW")
@Getter
@Setter
@NoArgsConstructor
public class DiningReview {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "REVIEWER_NAME")
    private String reviewerName;

    @Column(name = "RESTAURANT_ID")
    private Long restaurantId;

    @Column(name = "RATE")
    private Integer rate;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "REVIEW_STATUS")
    @Enumerated(EnumType.STRING)
    private AdminReviewStatus adminReviewStatus;

}
