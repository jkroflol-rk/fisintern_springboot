package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.entities.DetailBill;
import com.example.fisintern_spring.repositories.DetailBillRepository;
import com.example.fisintern_spring.services.DetailBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detailBills")
public class DetailBillController extends GenericController<DetailBill, Integer>{
    @Autowired
    private DetailBillRepository detailBillRepository;

    @Autowired
    private DetailBillService detailBillService;

    public DetailBillController(DetailBillService detailBillService, DetailBillRepository detailBillRepository) {
        super(detailBillService, detailBillRepository,"Bill");
    }
}
