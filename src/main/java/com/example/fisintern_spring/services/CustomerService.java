package com.example.fisintern_spring.services;

import com.example.fisintern_spring.models.Customer;
import com.example.fisintern_spring.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer findCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    public String updateCustomer(Integer id, String name){
        if (!customerRepository.existsById(id)) {
            return "Customer not found";
        }
        Customer customer = customerRepository.findById(id).get();
        customer.setName(name);
        customerRepository.save(customer);
        return "Updated";
    }
}
