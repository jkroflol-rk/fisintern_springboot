package com.example.fisintern_spring.services;

import com.example.fisintern_spring.entities.DetailBill;
import com.example.fisintern_spring.repositories.BillRepository;
import com.example.fisintern_spring.repositories.DetailBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailBillService extends GenericService<DetailBill, Integer>{
    @Autowired
    private DetailBillRepository detailBillRepository;

    public DetailBillService(DetailBillRepository detailBillRepository) {
        super(detailBillRepository);
    }
}
