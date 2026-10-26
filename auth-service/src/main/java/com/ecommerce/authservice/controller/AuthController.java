package com.ecommerce.authservice.controller;

import com.ecommerce.authservice.dto.AuthResponse;
import com.ecommerce.authservice.dto.LoginRequest;
import com.ecommerce.authservice.dto.SessionRequest;
import com.ecommerce.authservice.service.AuthService;
import com.ecommerce.authservice.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    SessionService sessionService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody @Valid LoginRequest loginRequest, HttpServletRequest httpServletRequest){
        return authService.login(loginRequest.getEmail(), loginRequest.getPassword(), httpServletRequest);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody @Valid SessionRequest sessionRequest, HttpServletRequest httpServletRequest){
        authService.logout(sessionRequest.getPlainRefreshToken(), httpServletRequest);
        return ResponseEntity.ok("Logout exitoso");
    }

    @PostMapping("/refreshToken")
    public AuthResponse refreshToken(@RequestBody @Valid SessionRequest sessionRequest, HttpServletRequest httpServletRequest){
        return sessionService.refreshAccesToken(sessionRequest.getPlainRefreshToken(), httpServletRequest);
    }

    @GetMapping("/ping")
    public ResponseEntity<?> ping(){
        return ResponseEntity.ok("Pong");
    }

}
