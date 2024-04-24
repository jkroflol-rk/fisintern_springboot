package com.example.fisintern_spring.services;

import com.example.fisintern_spring.models.Customer;
import com.example.fisintern_spring.repositories.BilliardTableRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class BilliardTableService {
    @Autowired
    private BilliardTableRepository tableRepository;
}
