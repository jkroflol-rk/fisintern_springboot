package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.models.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    @Query("SELECT z.hourlyPrice FROM Zone z WHERE z.id = ?1")
    BigDecimal findHourlyPriceById(Integer id);
}
