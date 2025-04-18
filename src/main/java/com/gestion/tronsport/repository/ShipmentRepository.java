package com.gestion.tronsport.repository;

import com.gestion.tronsport.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}