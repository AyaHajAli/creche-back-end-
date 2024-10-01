package com.example.crèche.service;

import com.example.crèche.model.Activite;
import com.example.crèche.repositry.ActiviteRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActiviteService {
    private final ActiviteRepositry activiteRepositry;

    public ActiviteService(ActiviteRepositry activiteRepositry) {
        this.activiteRepositry = activiteRepositry;
    }

    public Activite saveActivite(Activite activite) {
        return activiteRepositry.save(activite);
    }

    public void deleteActivite(Long id) {
        activiteRepositry.deleteById(id);
    }

    public List<Activite> getAllActivites() {
        return (List<Activite>) activiteRepositry.findAll();
    }

    public Activite updateActivite(Long id, Activite updatedActivite) {
        Optional<Activite> existingActiviteOptional = activiteRepositry.findById(id);
        if (existingActiviteOptional.isPresent()) {
            Activite existingActivite = existingActiviteOptional.get();
            existingActivite.setNom(updatedActivite.getNom());
            return activiteRepositry.save(existingActivite);
        } else {
            throw new RuntimeException("Activite not found with id: " + id);
        }
    }
}
