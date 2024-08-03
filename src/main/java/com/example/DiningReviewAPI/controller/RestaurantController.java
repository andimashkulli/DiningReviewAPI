package com.example.DiningReviewAPI.controller;
import com.example.DiningReviewAPI.model.Restaurant;
import com.example.DiningReviewAPI.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
private final UserRepository userRepository;
    public RestaurantController(RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        Optional<Restaurant> optionalRestaurant = this.restaurantRepository.findById(id);
        if(!optionalRestaurant.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Restaurant with the given id not found");
        }
        return optionalRestaurant.get();
    }
    @PostMapping("/newRestaurant")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        String restaurantName = restaurant.getRestaurantName();
        Integer restaurantZipCode = restaurant.getZipCode();
        if(restaurantRepository.existsByRestaurantNameAndZipCode(restaurantName,restaurantZipCode)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Restaurant with the given zip code and restaurant name already exists");
        }
        return this.restaurantRepository.save(restaurant);
    }
@GetMapping("/fetchWithZip/{zipCode}")
    public List<Restaurant> getRestaurantsWithZipCode(@PathVariable Integer zipCode) {
        if(this.restaurantRepository.existsByZipCode(zipCode) && this.userRepository.existsByZipCode(zipCode)){
            return this.restaurantRepository.findByZipCode(zipCode);
        }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no restaurant that matches with the user with the given zip code");
}
}