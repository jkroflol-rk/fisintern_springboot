package com.example.fisintern_spring.repositories;

import com.example.fisintern_spring.entities.Customer;
import org.springframework.data.jpa.repository.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT s FROM Customer s WHERE s.name LIKE %?1% OR s.phone LIKE %?1% OR s.email LIKE %?1%")
    List<Customer> findCustomer(String keyword);

    @Query("SELECT s FROM Customer s WHERE s.company IS NOT NULL")
    List<Customer> findCompanyCustomer();

    @Query("SELECT s FROM Customer s WHERE s.debt > 0")
    List<Customer> findDebtCustomer();

    @Query("SELECT s FROM Customer s WHERE s.dob BETWEEN ?1 and ?2")
    List<Customer> findBirthdayCustomer(LocalDate date1, LocalDate date2);

    @Query("SELECT s FROM Customer s WHERE s.sex = ?1")
    List<Customer> findCustomerBySex(Customer.Gender sex);

    @Query("SELECT s.debt FROM Customer s WHERE s.id = ?1")
    BigDecimal findDebtById(String name);

    @Query("SELECT s.total FROM Customer s WHERE s.id = ?1")
    BigDecimal findTotalById(String name);

    @Modifying
    @Query("update Customer s set s.debt = ?1 where s.id = ?2")
    void updateDebt(BigDecimal debt, Integer id);

    @Modifying
    @Query("update Customer s set s.total = ?1 where s.id = ?2")
    void updateTotal(BigDecimal total, Integer id);
}


