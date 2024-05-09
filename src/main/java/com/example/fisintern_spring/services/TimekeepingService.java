package com.example.fisintern_spring.services;

import com.example.fisintern_spring.entities.Timekeeping;
import com.example.fisintern_spring.repositories.TimekeepingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimekeepingService extends GenericService<Timekeeping, Integer>{

    @Autowired
    private TimekeepingRepository timekeepingRepository;

    public TimekeepingService(TimekeepingRepository timekeepingRepository) {
        super(timekeepingRepository);
    }
}
