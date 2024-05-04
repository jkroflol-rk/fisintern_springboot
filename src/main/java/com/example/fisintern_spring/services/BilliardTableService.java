package com.example.fisintern_spring.services;

import com.example.fisintern_spring.models.BilliardTable;
import com.example.fisintern_spring.models.Customer;
import com.example.fisintern_spring.repositories.BilliardTableRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class BilliardTableService {
    @Autowired
    private BilliardTableRepository tableRepository;

    public BilliardTable findTableById(Integer id) {
        return tableRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Table not found"));
    }

    public String deleteTable(Integer id) {
        BilliardTable table = tableRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Table not found"));
        tableRepository.deleteById(id);
        return "Deleted table with id " + id + ".";
    }

    public String updateTable(Integer id, BilliardTable table){
        if (!tableRepository.existsById(id)) {
            tableRepository.save(table);
            return "Customer not found, new customer added.";
        }
        BilliardTable oldTable = tableRepository.findById(id).get();

        // Use reflection to iterate over all fields in the Customer class
        for (Field field : BilliardTable.class.getDeclaredFields()) {
            field.setAccessible(true); // You need this if fields are private
            Object newValue;
            try {
                // Get the value of the field in the new customer object
                newValue = field.get(table);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing field " + field.getName(), e);
            }

            // If the new value is not null, update the old customer object
            if (newValue != null) {
                try {
                    field.set(oldTable, newValue);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error updating field " + field.getName(), e);
                }
            }
        }

        tableRepository.save(oldTable);
        return "Updated customer with id " + id + ".";
    }
}
