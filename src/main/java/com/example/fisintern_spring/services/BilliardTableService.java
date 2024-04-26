package com.example.fisintern_spring.services;

import com.example.fisintern_spring.models.Customer;
import com.example.fisintern_spring.repositories.BilliardTableRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilliardTableService {
    @Autowired
    private BilliardTableRepository tableRepository;
}
