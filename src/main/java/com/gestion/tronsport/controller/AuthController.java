package com.gestion.tronsport.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.tronsport.dto.LoginRequest;
import com.gestion.tronsport.dto.RegisterRequest;
import com.gestion.tronsport.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {
    "http://localhost:5173",
    "http://localhost:5174",
    "https://tronsport-frontend.onrender.com",
    "https://gestion-tronsport-idgt.vercel.app",
    "https://gestion-tronsport-idqt.vercel.app"
})
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            System.out.println("Received registration request: " + request.getName() + ", " + request.getEmail());
            System.out.println("Request details: " + request);

            // Validate request
            if (request.getName() == null || request.getName().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Name is required");
            }
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Email is required");
            }
            if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Password is required");
            }

            authService.register(request);
            System.out.println("User registered successfully: " + request.getEmail());
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
            System.out.println("Received login request for: " + request.getEmail());
            boolean isAuthenticated = authService.login(request);
            if (isAuthenticated) {
                // Create a simple response with a token
                return ResponseEntity.ok().body(java.util.Map.of(
                    "token", "dummy-token-" + java.util.UUID.randomUUID().toString(),
                    "message", "Login successful"
                ));
            } else {
                return ResponseEntity.badRequest().body("Invalid credentials");
            }
        } catch (Exception e) {
            System.out.println("Login error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }
}

