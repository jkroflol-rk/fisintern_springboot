package com.example.fisintern_spring.services;

import com.example.fisintern_spring.repositories.ReservationRepository;
import com.example.fisintern_spring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
}
