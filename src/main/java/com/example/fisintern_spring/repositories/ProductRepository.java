package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
