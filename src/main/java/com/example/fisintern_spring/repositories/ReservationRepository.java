package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
