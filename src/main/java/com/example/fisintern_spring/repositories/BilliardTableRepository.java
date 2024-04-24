package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.models.BilliardTable;
import com.example.fisintern_spring.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BilliardTableRepository extends JpaRepository<BilliardTable, Integer> {
    @Query("SELECT s FROM BilliardTable s WHERE s.status = ?1")
    List<BilliardTable> findTableByStatus(String status);
}


