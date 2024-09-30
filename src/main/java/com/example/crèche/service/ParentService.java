package com.example.crèche.service;

import com.example.crèche.model.Parent;
import com.example.crèche.model.User;
import com.example.crèche.repositry.ParentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {
    private final ParentRepositry parentRepositry;

    @Autowired
    public ParentService(ParentRepositry parentRepositry) {
        this.parentRepositry = parentRepositry;
    }

    public Parent saveParent(Parent parent) {
        return parentRepositry.save(parent);
    }

    public void deleteParent(Long id) {
        parentRepositry.deleteById(id);
    }

    public List<Parent> getAllParents() {
        return (List<Parent>) parentRepositry.findAll();
    }

    public Parent updateParent(Long id, Parent updatedParent) {
        Optional<Parent> existingParentOptional = parentRepositry.findById(id);
        if (existingParentOptional.isPresent()) {
            Parent existingParent = existingParentOptional.get();
            existingParent.setNom(updatedParent.getNom());
            existingParent.setPrenom(updatedParent.getPrenom());
            existingParent.setUsername(updatedParent.getUsername());
            existingParent.setEmail(updatedParent.getEmail());
            existingParent.setPassword(updatedParent.getPassword());
            existingParent.setAdresse(updatedParent.getAdresse());
            existingParent.setTelephone(updatedParent.getTelephone());
            return parentRepositry.save(existingParent);
        } else {
            throw new RuntimeException("Parent not found with id: " + id);
        }
    }}

