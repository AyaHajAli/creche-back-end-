package com.example.crèche.controller;

import com.example.crèche.model.Employe;
import com.example.crèche.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employes")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeController {
    private final EmployeService employeService;

    @Autowired
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/save")
    public Employe saveEmploye(@RequestBody Employe employe) {
        return employeService.saveEmploye(employe);
    }

    public List<Employe> getAllEmployes() {
        return employeService.getAllEmployes();
    }

    @DeleteMapping("/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        employeService.deleteEmploye(id);
    }

    @PutMapping("/{id}")
    public Employe updateEmploye(@PathVariable Long id, @RequestBody Employe employeDetails) {
        return employeService.updateEmploye(id, employeDetails);
    }
}
