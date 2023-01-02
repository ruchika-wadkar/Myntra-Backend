package com.myntra.backend.Repository;

import com.myntra.backend.Entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliersRepository extends JpaRepository<Supplier, Integer>{
}
