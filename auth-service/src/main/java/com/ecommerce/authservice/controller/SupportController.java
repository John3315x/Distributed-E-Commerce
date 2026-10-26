package com.ecommerce.authservice.controller;

import com.ecommerce.authservice.dto.user.UserDto;
import com.ecommerce.authservice.service.UserServiceClient;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/support")
public class SupportController {

    // 👷‍♂️🚧 Microservicio: User Service
    @Autowired
    UserServiceClient userServiceClient;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserDto userDto, HttpServletRequest httpServletRequest) {
        return userServiceClient.createUser(userDto, httpServletRequest);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto, HttpServletRequest httpServletRequest){
        return userServiceClient.updateUser(id, userDto, httpServletRequest);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id){
        return userServiceClient.getUser(id);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<?> getUsers(){
        return userServiceClient.getUsers();
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return userServiceClient.deleteUser(id);
    }
}
