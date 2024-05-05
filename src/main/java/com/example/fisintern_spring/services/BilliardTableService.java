package com.example.fisintern_spring.services;

import com.example.fisintern_spring.models.BilliardTable;
import com.example.fisintern_spring.repositories.BilliardTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BilliardTableService extends GenericService<BilliardTable, Integer> {
    @Autowired
    private BilliardTableRepository tableRepository;

    public BilliardTableService(BilliardTableRepository tableRepository) {
        super(tableRepository);
    }
}
