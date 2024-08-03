package com.example.DiningReviewAPI.controller;
import com.example.DiningReviewAPI.model.AdminReviewStatus;
import com.example.DiningReviewAPI.model.DiningReview;
import com.example.DiningReviewAPI.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.Optional;

@RestController
@RequestMapping("/diningReview")
public class DiningReviewController {
    private final DiningReviewRepository diningReviewRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    public DiningReviewController(DiningReviewRepository diningReviewRepository,UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.diningReviewRepository = diningReviewRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }
    @GetMapping("/admin/getAllOfThem")
    public Iterable<DiningReview> getAllOfThem() {
return this.diningReviewRepository.findAll();
    }
    @PostMapping("/newReviewDining")
    public DiningReview newReviewDining(@RequestBody DiningReview diningReview) {
        String reviewerName = diningReview.getReviewerName();
        Long restaurantId = diningReview.getRestaurantId();
        if(!this.userRepository.existsByUsername(reviewerName)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User does not exist to add this review");
        }
        if(!this.restaurantRepository.existsById(restaurantId)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Restaurant does not exits with that name to add this review");
        }
        return this.diningReviewRepository.save(diningReview);
    }
    @PutMapping("/admin/editReviewStatus/{id}/{status}")
   public DiningReview editReviewStatus(@PathVariable("id") Long id,@PathVariable("status") AdminReviewStatus status) {

        Optional<DiningReview> diningReviewOptional = this.diningReviewRepository.findById(id);
        if(!diningReviewOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This dining review with the given id does not exist");
        }
       DiningReview diningReviewToUpdate = diningReviewOptional.get();
        diningReviewToUpdate.setAdminReviewStatus(status);
        return this.diningReviewRepository.save(diningReviewToUpdate);
    }
}
