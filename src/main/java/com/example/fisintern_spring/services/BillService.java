package com.example.fisintern_spring.services;

import com.example.fisintern_spring.entities.Bill;
import com.example.fisintern_spring.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService extends GenericService<Bill, Integer>{
    @Autowired
    private BillRepository billRepository;

    public BillService(BillRepository billRepository) {
        super(billRepository);
    }
}
