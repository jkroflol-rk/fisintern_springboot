package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.models.Customer;
import org.springframework.data.jpa.repository.*;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT s FROM Customer s WHERE s.name LIKE %?1%")
    List<Customer> findCustomerByName(String first_name);
}


