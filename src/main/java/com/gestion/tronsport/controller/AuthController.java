package com.gestion.tronsport.controller;

import com.gestion.tronsport.dto.LoginRequest;
import com.gestion.tronsport.dto.RegisterRequest;
import com.gestion.tronsport.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            System.out.println("Received registration request: " + request.getName() + ", " + request.getEmail());
            authService.register(request);
            return ResponseEntity.ok().body("User registered successfully");
        } catch (RuntimeException e) {
            System.out.println("Registration error: " + e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("An unexpected error occurred");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            boolean isAuthenticated = authService.login(request);
            if (isAuthenticated) {
                return ResponseEntity.ok().body("Login successful");
            } else {
                return ResponseEntity.badRequest().body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
}

