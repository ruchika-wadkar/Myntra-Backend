package com.myntra.backend.Repository;

import com.myntra.backend.Entities.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<Shipper, Integer> {
}