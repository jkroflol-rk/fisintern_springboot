package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
