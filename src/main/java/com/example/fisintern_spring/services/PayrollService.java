package com.example.fisintern_spring.services;

import com.example.fisintern_spring.entities.Payroll;
import com.example.fisintern_spring.repositories.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayrollService extends GenericService<Payroll, Integer>{

    @Autowired
    private PayrollRepository payrollRepository;

    public PayrollService(PayrollRepository payrollRepository) {
        super(payrollRepository);
    }
}
