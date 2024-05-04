package com.example.fisintern_spring.services;

import com.example.fisintern_spring.models.Reservation;
import com.example.fisintern_spring.repositories.ReservationRepository;
import com.example.fisintern_spring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public String deleteReservation(Integer id) {
        reservationRepository.deleteById(id);
        return "Deleted reservation with id " + id + ".";
    }

    public String updateEndTime(Integer id, LocalDateTime endTime) {
        reservationRepository.updateEndTime(endTime, id);
        reservationRepository.updateTotalTime(id);
        return "Updated reservation end time with id " + id + ".";
    }
}
