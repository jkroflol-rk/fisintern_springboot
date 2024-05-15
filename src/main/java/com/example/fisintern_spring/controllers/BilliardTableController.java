package com.example.fisintern_spring.controllers;

import com.example.fisintern_spring.entities.BilliardTable;
import com.example.fisintern_spring.repositories.BilliardTableRepository;
import com.example.fisintern_spring.services.BilliardTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tables")
@PreAuthorize("hasAuthority('admin')")
public class BilliardTableController extends GenericController<BilliardTable, Integer> {
    @Autowired
    private BilliardTableRepository tableRepository;

    @Autowired
    private BilliardTableService tableService;

    public BilliardTableController(BilliardTableService tableService, BilliardTableRepository tableRepository) {
        super(tableService, tableRepository, "Table");
    }

    @GetMapping(path = "/findbyname")
    public @ResponseBody List<BilliardTable> getAllUsers(@RequestParam String keyword) {
        // This returns a JSON or XML with the users
        return tableRepository.findTable(keyword);
    }

    @GetMapping(path = "/status/{status}")
    public @ResponseBody List<BilliardTable> getTableByStatus(@PathVariable BilliardTable.Status status) {
        return tableRepository.findTableByStatus(status);
    }

    @GetMapping(path = "/findbyzone/{zone}")
    public @ResponseBody List<BilliardTable> getTableByZone(@PathVariable Integer zone) {
        return tableRepository.findTableByZone(zone);
    }
}


