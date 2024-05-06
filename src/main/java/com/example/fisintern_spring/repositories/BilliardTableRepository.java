package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.entities.BilliardTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BilliardTableRepository extends JpaRepository<BilliardTable, Integer> {
    @Query("SELECT s FROM BilliardTable s WHERE s.btableName LIKE %?1%")
    List<BilliardTable> findTable(String keyword);

    @Query("SELECT s FROM BilliardTable s WHERE s.status = ?1")
    List<BilliardTable> findTableByStatus(BilliardTable.Status status);

    @Query("SELECT s FROM BilliardTable s WHERE s.zone = ?1")
    List<BilliardTable> findTableByZone(Integer zone);

    @Query("SELECT s.zone FROM BilliardTable s WHERE s.id = ?1")
    Integer findZoneIdByTableId(Integer tableId);
}

