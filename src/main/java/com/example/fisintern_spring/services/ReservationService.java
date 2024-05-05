package com.example.fisintern_spring.services;

import com.example.fisintern_spring.models.Reservation;
import com.example.fisintern_spring.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationService extends GenericService<Reservation, Integer>{
    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        super(reservationRepository);
    }

    public String updateEndTime(Integer id, LocalDateTime endTime) {
        reservationRepository.updateEndTime(endTime, id);
        reservationRepository.updateTotalTime(id);
        return "Updated reservation end time with id " + id + ".";
    }
}
