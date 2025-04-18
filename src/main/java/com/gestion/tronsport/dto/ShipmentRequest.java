package com.gestion.tronsport.dto;

import lombok.Data;

@Data
public class ShipmentRequest {
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
}