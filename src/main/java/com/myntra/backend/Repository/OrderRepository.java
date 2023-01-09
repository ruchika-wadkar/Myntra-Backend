package com.myntra.backend.Repository;


import com.myntra.backend.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomerCustomerID(int cid);
}

