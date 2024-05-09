package com.example.fisintern_spring.services;

import com.example.fisintern_spring.entities.Role;
import com.example.fisintern_spring.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends GenericService<Role, Integer>{

    @Autowired
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        super(roleRepository);
    }
}
