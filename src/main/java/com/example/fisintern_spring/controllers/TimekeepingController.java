package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.entities.Timekeeping;
import com.example.fisintern_spring.repositories.TimekeepingRepository;
import com.example.fisintern_spring.services.TimekeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timekeeping")
public class TimekeepingController extends GenericController<Timekeeping, Integer>{
    @Autowired
    private TimekeepingService timekeepingService;

    @Autowired
    private TimekeepingRepository timekeepingRepository;

    public TimekeepingController(TimekeepingService timekeepingService, TimekeepingRepository timekeepingRepository) {
        super(timekeepingService, timekeepingRepository, "Timekeeping");
    }
}
