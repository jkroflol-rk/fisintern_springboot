package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
