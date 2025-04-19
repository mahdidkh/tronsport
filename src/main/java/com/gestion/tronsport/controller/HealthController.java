package com.gestion.tronsport.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/health")
@CrossOrigin(origins = {
    "http://localhost:5173",
    "http://localhost:5174",
    "https://tronsport-frontend.onrender.com",
    "https://gestion-tronsport-idgt.vercel.app",
    "https://gestion-tronsport-idqt.vercel.app"
})
public class HealthController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("message", "Service is running");
        response.put("timestamp", System.currentTimeMillis());

        return ResponseEntity.ok(response);
    }
}
