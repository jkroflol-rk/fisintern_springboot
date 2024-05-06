package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.entities.Customer;
import com.example.fisintern_spring.repositories.CustomerRepository;
import com.example.fisintern_spring.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController extends GenericController<Customer, Integer> {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        super(customerService, customerRepository, "Customer");
    }

    @GetMapping(path = "/find")
    public @ResponseBody List<Customer> findCustomerByName(@RequestParam String keyword) {
        // This returns a JSON or XML with the users
        return customerRepository.findCustomer(keyword);
    }

    @GetMapping(path = "/findcompany")
    public @ResponseBody List<Customer> findCompanyCustomer() {
        return customerRepository.findCompanyCustomer();
    }

    @GetMapping(path = "/finddebt")
    public @ResponseBody List<Customer> findDebtCustomer() {
        return customerRepository.findDebtCustomer();
    }

    @GetMapping(path = "/findbirthday")
    public @ResponseBody List<Customer> findBirthdayCustomer(@RequestParam String d1, @RequestParam String d2) {
        LocalDate date1 = LocalDate.parse(d1);
        LocalDate date2 = LocalDate.parse(d2);
        return customerRepository.findBirthdayCustomer(date1, date2);
    }

    @GetMapping(path = "/findbysex/{sex}")
    public @ResponseBody List<Customer> findBirthdayCustomer(@PathVariable Customer.Gender sex) {
        return customerRepository.findCustomerBySex(sex);
    }
}


