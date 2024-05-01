package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.models.Reservation;
import com.example.fisintern_spring.repositories.ReservationRepository;
import com.example.fisintern_spring.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationService reservationService;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Reservation> getAllUsers() {
        return reservationRepository.findAll();
    }
}
