package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.services.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<T, ID> {

    private GenericService<T, ID> service;
    private JpaRepository<T, ID> repository;
    private String entityName;

    public GenericController(GenericService<T, ID> service, JpaRepository<T, ID> repository,String entityName) {
        this.service = service;
        this.repository = repository;
        this.entityName = entityName;
    }

    @GetMapping("/all")
    public @ResponseBody List<T> getAll() {
        return repository.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public @ResponseBody T findById(@PathVariable ID id) {
        return service.findById(id, entityName);
    }

    @PostMapping("/add")
    public @ResponseBody T add(@RequestBody T entity) {
        return repository.save(entity);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public @ResponseBody String delete(@PathVariable ID id) {
        return service.deleteById(id, entityName);
    }

    @PutMapping("/update/{id}")
    public @ResponseBody String update(@PathVariable ID id, @RequestBody T entity) {
        return service.update(id, entity);
    }
}
