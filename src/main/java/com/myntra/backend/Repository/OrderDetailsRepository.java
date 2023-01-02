package com.myntra.backend.Repository;

import com.myntra.backend.Entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Integer> {
}
