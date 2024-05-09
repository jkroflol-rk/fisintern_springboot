package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.entities.Role;
import com.example.fisintern_spring.repositories.RoleRepository;
import com.example.fisintern_spring.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RoleController extends GenericController<Role, Integer>{

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;

    public RoleController(RoleService roleService, RoleRepository roleRepository) {
        super(roleService, roleRepository, "Role");
    }
}
