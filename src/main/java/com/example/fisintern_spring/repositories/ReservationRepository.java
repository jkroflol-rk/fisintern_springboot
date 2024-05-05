package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query("SELECT r FROM Reservation r WHERE r.startTime <= ?1 AND r.endTime >= ?1")
    Iterable<Reservation> findReservationsByTime(LocalDateTime time);

    @Transactional
    @Modifying
    @Query("UPDATE Reservation r SET r.status = ?1 WHERE r.id = ?2")
    void updateStatus(Reservation.Status status, Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Reservation r SET r.endTime = ?1 WHERE r.id = ?2")
    void updateEndTime(LocalDateTime endTime, Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Reservation r SET r.totalTime = TIMESTAMPDIFF(SECOND, r.startTime, r.endTime) / 3600.0 WHERE r.id = ?1")
    void updateTotalTime(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Reservation r SET r.totalPrice = r.totalTime * ?1 WHERE r.id = ?2")
    void updateTotalCost(BigDecimal rate, Integer id);
}
