package com.example.crèche.service;

import com.example.crèche.model.Enfant;
import com.example.crèche.repositry.EnfantRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnfantService {
    private final EnfantRepositry enfantRepositry;

    public EnfantService(EnfantRepositry enfantRepositry) {
        this.enfantRepositry = enfantRepositry;
    }

    public List<Enfant> findEnfantsByNom(String nom) {
        return enfantRepositry.findByNom(nom);
    }

    public Enfant saveEnfant(Enfant enfant) {
        return enfantRepositry.save(enfant);
    }

    public void deleteEnfant(Long id) {
        enfantRepositry.deleteById(id);
    }

    public List<Enfant> getAllEnfants() {
        return (List<Enfant>) enfantRepositry.findAll();
    }

    public Enfant updateEnfant(Long id, Enfant updatedEnfant) {
        Optional<Enfant> existingEnfantOptional = enfantRepositry.findById(id);
        if (existingEnfantOptional.isPresent()) {
            Enfant existingEnfant = existingEnfantOptional.get();
            existingEnfant.setNom(updatedEnfant.getNom());
            existingEnfant.setPrenom(updatedEnfant.getPrenom());
            existingEnfant.setDateNaissance(updatedEnfant.getDateNaissance());
            existingEnfant.setAge(updatedEnfant.getAge());
            existingEnfant.setGenre(updatedEnfant.getGenre());
            return enfantRepositry.save(existingEnfant);
        } else {
            throw new RuntimeException("Enfant not found with id: " + id);
        }
    }


    public long countEnfants() {
        return enfantRepositry.count();
    }

    public List<Enfant> rechercherParNom(String nom) {
        // Appeler le repository pour rechercher les enfants par nom
        return enfantRepositry.findByNom(nom);
    }

}
