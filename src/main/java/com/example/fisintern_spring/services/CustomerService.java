package com.example.fisintern_spring.services;

import com.example.fisintern_spring.models.Customer;
import com.example.fisintern_spring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public String addNewCustomer(String name, String email) {
        Customer n = new Customer();
        n.setName(name);
        n.setEmail(email);
        customerRepository.save(n);
        return "Saved";
    }
}
