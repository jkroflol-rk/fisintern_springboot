package com.example.fisintern_spring.services;

import com.example.fisintern_spring.entities.Supplier;
import com.example.fisintern_spring.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService extends GenericService<Supplier, Integer>{

    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        super(supplierRepository);
    }
}
