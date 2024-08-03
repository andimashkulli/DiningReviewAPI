package com.example.DiningReviewAPI.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="RESTAURANT")
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "RESTAURANT_NAME")
    private String restaurantName;

    @Column(name = "RESTAURANT_LOCATION")
    private String restaurantLocation;

    @Column(name = "ZIP_CODE")
    private Integer zipCode;

}
