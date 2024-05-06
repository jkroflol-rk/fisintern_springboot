package com.example.fisintern_spring.services;

import com.example.fisintern_spring.entities.Reservation;
import com.example.fisintern_spring.repositories.BilliardTableRepository;
import com.example.fisintern_spring.repositories.ReservationRepository;
import com.example.fisintern_spring.repositories.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationService extends GenericService<Reservation, Integer>{
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private BilliardTableRepository billiardTableRepository;

    @Autowired
    private ZoneRepository zoneRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        super(reservationRepository);
    }

    public String updateEndTime(Integer id, LocalDateTime endTime) {
        reservationRepository.updateEndTime(endTime, id);
        reservationRepository.updateTotalTime(id);
        Integer zoneId = billiardTableRepository.findZoneIdByTableId(findById(id, "").getBtableId());
        reservationRepository.updateTotalCost(zoneRepository.findHourlyPriceById(zoneId), id);
        return "Updated reservation end time with id " + id + ".";
    }
}
