package com.gestion.tronsport.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Merchandise Information
    private String merchandiseName;
    private Double weight;
    private String description;

    // Shipper Information
    private String shipperName;
    private String shipperAddress;
    private String shipperEmail;
    private String shipperPhone;

    // Destination Information
    private String receiverName;
    private String receiverAddress;
    private String receiverEmail;
    private String receiverPhone;

    // Additional Information
    private String transportType;
    private Double shippingCost;
    private String service;
    private String modeOfTransport;

    // Payment Information
    private String paymentMethod;
    
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}