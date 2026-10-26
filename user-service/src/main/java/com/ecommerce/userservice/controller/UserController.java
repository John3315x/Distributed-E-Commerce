package com.ecommerce.userservice.controller;

import com.ecommerce.userservice.dto.UserDto;
import com.ecommerce.userservice.entity.User;
import com.ecommerce.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserDto userDto) {

        userService.createUser(userDto);
        return ResponseEntity.status(201).body("User created successfully");
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto) {

        userService.updateUser(id, userDto);
        return ResponseEntity.status(201).body("User updated successfully");
    }

    @GetMapping("/getUser/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/getUserByEmail/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

}
