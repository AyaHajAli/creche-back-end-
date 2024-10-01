package com.example.crèche.service;

import com.example.crèche.model.Employe;
import com.example.crèche.repositry.EmployeRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {
    private final EmployeRepositry employeRepositry;

    public EmployeService(EmployeRepositry employeRepositry) {
        this.employeRepositry = employeRepositry;
    }

    public Employe saveEmploye(Employe employe) {
        return employeRepositry.save(employe);
    }

    public void deleteEmploye(Long id) {
        employeRepositry.deleteById(id);
    }

    public List<Employe> getAllEmployes() {
        return (List<Employe>) employeRepositry.findAll();
    }

    public Employe updateEmploye(Long id, Employe updatedEmploye) {
        Optional<Employe> existingEmployeOptional = employeRepositry.findById(id);
        if (existingEmployeOptional.isPresent()) {
            Employe existingEmploye = existingEmployeOptional.get();
            existingEmploye.setNom(updatedEmploye.getNom());
            existingEmploye.setPrenom(updatedEmploye.getPrenom());
            existingEmploye.setUsername(updatedEmploye.getUsername());
            existingEmploye.setEmail(updatedEmploye.getEmail());
            existingEmploye.setPassword(updatedEmploye.getPassword());
            existingEmploye.setAdresse(updatedEmploye.getAdresse());
            existingEmploye.setTelephone(updatedEmploye.getTelephone());
            return employeRepositry.save(existingEmploye);
        } else {
            throw new RuntimeException("Employe not found with id: " + id);
        }
    }
}
