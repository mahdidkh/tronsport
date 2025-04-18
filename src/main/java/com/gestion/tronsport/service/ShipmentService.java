package com.gestion.tronsport.service;

import com.gestion.tronsport.dto.ShipmentRequest;
import com.gestion.tronsport.entity.Shipment;
import com.gestion.tronsport.repository.ShipmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment createShipment(ShipmentRequest request) {
        Shipment shipment = new Shipment();
        
        // Set Merchandise Information
        shipment.setMerchandiseName(request.getMerchandiseName());
        shipment.setWeight(request.getWeight());
        shipment.setDescription(request.getDescription());

        // Set Shipper Information
        shipment.setShipperName(request.getShipperName());
        shipment.setShipperAddress(request.getShipperAddress());
        shipment.setShipperEmail(request.getShipperEmail());
        shipment.setShipperPhone(request.getShipperPhone());

        // Set Destination Information
        shipment.setReceiverName(request.getReceiverName());
        shipment.setReceiverAddress(request.getReceiverAddress());
        shipment.setReceiverEmail(request.getReceiverEmail());
        shipment.setReceiverPhone(request.getReceiverPhone());

        // Set Additional Information
        shipment.setTransportType(request.getTransportType());
        shipment.setShippingCost(request.getShippingCost());
        shipment.setService(request.getService());
        shipment.setModeOfTransport(request.getModeOfTransport());

        // Set Payment Information
        shipment.setPaymentMethod(request.getPaymentMethod());

        return shipmentRepository.save(shipment);
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Shipment not found"));
    }
}