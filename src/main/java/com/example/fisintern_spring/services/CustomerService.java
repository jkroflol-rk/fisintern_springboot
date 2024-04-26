package com.example.fisintern_spring.services;

import com.example.fisintern_spring.models.Customer;
import com.example.fisintern_spring.repositories.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer findCustomerById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    public String updateCustomer(Integer id, Customer customer){
        if (!customerRepository.existsById(id)) {
            customerRepository.save(customer);
            return "Customer not found, new customer added.";
        }
        Customer oldCustomer = customerRepository.findById(id).get();

        // Use reflection to iterate over all fields in the Customer class
        for (Field field : Customer.class.getDeclaredFields()) {
            field.setAccessible(true); // You need this if fields are private
            Object newValue;
            try {
                // Get the value of the field in the new customer object
                newValue = field.get(customer);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing field " + field.getName(), e);
            }

            // If the new value is not null, update the old customer object
            if (newValue != null) {
                try {
                    field.set(oldCustomer, newValue);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error updating field " + field.getName(), e);
                }
            }
        }

        customerRepository.save(oldCustomer);
        return "Updated customer with id " + id + ".";
    }
}
