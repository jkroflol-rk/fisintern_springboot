package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.entities.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
