package com.example.fisintern_spring.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;

public abstract class GenericService<T, ID> {

    private JpaRepository<T, ID> repository;

    public GenericService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T findById(ID id, String entityName) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException(entityName + " not found"));
    }

    public String deleteById(ID id, String entityName) {
        T entity = repository.findById(id).orElseThrow(() -> new RuntimeException(entityName + " not found"));
        repository.deleteById(id);
        return "Deleted entity with id " + id + ".";
    }

    public String update(ID id, T entity){
        if (!repository.existsById(id)) {
            repository.save(entity);
            return "Entity not found, new entity added.";
        }
        T oldEntity = repository.findById(id).get();

        // Use reflection to iterate over all fields in the entity class
        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true); // You need this if fields are private
            Object newValue;
            try {
                // Get the value of the field in the new entity object
                newValue = field.get(entity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing field " + field.getName(), e);
            }

            // If the new value is not null, update the old entity object
            if (newValue != null) {
                try {
                    field.set(oldEntity, newValue);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error updating field " + field.getName(), e);
                }
            }
        }

        repository.save(oldEntity);
        return "Updated entity with id " + id + ".";
    }
}
