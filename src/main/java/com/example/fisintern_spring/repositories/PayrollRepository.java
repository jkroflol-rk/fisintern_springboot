package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.entities.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Integer> {
}
