package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.entities.Timekeeping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimekeepingRepository extends JpaRepository<Timekeeping, Integer> {
}
