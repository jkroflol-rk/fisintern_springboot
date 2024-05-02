package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query("SELECT r FROM Reservation r WHERE r.startTime <= ?1 AND r.endTime >= ?1")
    Iterable<Reservation> findReservationsByTime(LocalDateTime time);

    @Query("UPDATE Reservation r SET r.status = ?1 WHERE r.id = ?2")
    void updateStatus(Reservation.Status status, Integer id);
}
