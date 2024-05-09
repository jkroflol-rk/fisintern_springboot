package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.entities.Bill;
import com.example.fisintern_spring.repositories.BillRepository;
import com.example.fisintern_spring.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bills")
public class BillController extends GenericController<Bill, Integer>{
    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BillService billService;

    public BillController(BillService billService, BillRepository billRepository) {
        super(billService, billRepository, "Bill");
    }
}
