package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.entities.Employee;
import com.example.fisintern_spring.repositories.EmployeeRepository;
import com.example.fisintern_spring.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController extends GenericController<Employee, Integer>{

    @Autowired
    private EmployeeRepository supplierRepository;

    @Autowired
    private EmployeeService supplierService;

    public EmployeeController(EmployeeService supplierService, EmployeeRepository supplierRepository) {
        super(supplierService, supplierRepository, "Employee");
    }
}
