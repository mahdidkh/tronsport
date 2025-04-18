package com.gestion.tronsport.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/basic-health")
@CrossOrigin(origins = {"*"})
public class BasicHealthController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> basicHealthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("message", "Basic health check passed");
        response.put("timestamp", System.currentTimeMillis());
        
        // Add system information
        response.put("java.version", System.getProperty("java.version"));
        response.put("os.name", System.getProperty("os.name"));
        response.put("user.dir", System.getProperty("user.dir"));
        
        return ResponseEntity.ok(response);
    }
}
