package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.models.Reservation;
import com.example.fisintern_spring.repositories.ReservationRepository;
import com.example.fisintern_spring.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    @GetMapping(path = "/findbytime")
    public @ResponseBody Iterable<Reservation> findReservationsByTime(@RequestParam String t) {
        LocalDateTime time = LocalDateTime.parse(t);
        return reservationRepository.findReservationsByTime(time);
    }

    @PostMapping(path = "/add")
    public @ResponseBody Reservation addNewReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteReservation(@PathVariable int id) {
        reservationRepository.deleteById(id);
        return "Deleted reservation with id " + id + ".";
    }

    @PutMapping(path = "/updatestatus/{id}")
    public @ResponseBody String updateReservationStatus(@PathVariable Integer id, @RequestBody Reservation.Status status) {
        reservationRepository.updateStatus(status, id);
        return "Updated reservation status with id " + id + " to " + status + ".";
    }

}
