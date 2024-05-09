package com.example.fisintern_spring.services;

import com.example.fisintern_spring.entities.Employee;
import com.example.fisintern_spring.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService extends GenericService<Employee, Integer> {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        super(employeeRepository);
    }
}
