package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.entities.Payroll;
import com.example.fisintern_spring.repositories.PayrollRepository;
import com.example.fisintern_spring.services.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payroll")
public class PayrollController extends GenericController<Payroll, Integer>{
    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private PayrollService payrollService;

    public PayrollController(PayrollService payrollService, PayrollRepository payrollRepository) {
        super(payrollService, payrollRepository, "Payroll");
    }
}
