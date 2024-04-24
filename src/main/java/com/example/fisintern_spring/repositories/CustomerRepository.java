package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.models.Customer;
import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT s FROM Customer s WHERE s.name LIKE %?1% OR s.phone LIKE %?1% OR s.email LIKE %?1%")
    List<Customer> findCustomer(String keyword);

    @Query("SELECT s FROM Customer s WHERE s.company IS NOT NULL")
    List<Customer> findCompanyCustomer();

    @Query("SELECT s FROM Customer s WHERE s.debt > 0")
    List<Customer> findDebtCustomer();

    @Query("SELECT s FROM Customer s WHERE s.dob BETWEEN ?1 and ?2")
    List<Customer> findBirthdayCustomer(LocalDate date1, LocalDate date2);
}


