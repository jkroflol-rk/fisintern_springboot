package com.example.fisintern_spring.services;

import com.example.fisintern_spring.entities.Customer;
import com.example.fisintern_spring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService extends GenericService<Customer, Integer> {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
    }
}
