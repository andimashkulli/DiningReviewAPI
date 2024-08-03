package com.example.DiningReviewAPI.controller;
import com.example.DiningReviewAPI.model.*;
import com.example.DiningReviewAPI.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/")
    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }
@GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable Long id) {
        return this.userRepository.findById(id);
}
@PostMapping("/newUser")
    public User createUser(@RequestBody User user) {
        if (this.userRepository.existsByUsername(user.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with that username already exists");
        }
        return this.userRepository.save(user);
}
@PutMapping("/update/{id}")
public User updateUser(@RequestParam Long id, @RequestBody User user) {
     Optional<User> userOptional = this.userRepository.findById(id);
    if (userOptional.isPresent()) {
        User updatedUser = userOptional.get();
        updatedUser.setZipCode(user.getZipCode());
        updatedUser.setCity(user.getCity());
        updatedUser.setState(user.getState());

    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with that id does not exist");
}
}
