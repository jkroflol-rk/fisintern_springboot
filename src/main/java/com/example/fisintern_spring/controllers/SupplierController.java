package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.entities.Supplier;
import com.example.fisintern_spring.repositories.SupplierRepository;
import com.example.fisintern_spring.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/suppliers")
public class SupplierController extends GenericController<Supplier, Integer>{

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService, SupplierRepository supplierRepository) {
        super(supplierService, supplierRepository, "Supplier");
    }
}
