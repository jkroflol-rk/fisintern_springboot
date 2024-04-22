package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.models.Customer;
import org.springframework.data.jpa.repository.*;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}


