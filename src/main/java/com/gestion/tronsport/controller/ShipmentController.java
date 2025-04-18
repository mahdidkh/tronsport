package com.gestion.tronsport.controller;

import com.gestion.tronsport.dto.ShipmentRequest;
import com.gestion.tronsport.entity.Shipment;
import com.gestion.tronsport.service.ShipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
public class ShipmentController {
    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ResponseEntity<Shipment> createShipment(@RequestBody ShipmentRequest request) {
        System.out.println("Received shipment request");
        try {
            Shipment shipment = shipmentService.createShipment(request);
            System.out.println("Shipment created successfully");
            return ResponseEntity.ok(shipment);
        } catch (Exception e) {
            System.err.println("Error creating shipment: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping
    public ResponseEntity<List<Shipment>> getAllShipments() {
        List<Shipment> shipments = shipmentService.getAllShipments();
        return ResponseEntity.ok(shipments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getShipmentById(@PathVariable Long id) {
        Shipment shipment = shipmentService.getShipmentById(id);
        return ResponseEntity.ok(shipment);
    }
}