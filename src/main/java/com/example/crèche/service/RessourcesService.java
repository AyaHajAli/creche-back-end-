package com.example.crèche.service;

import com.example.crèche.model.Ressources;
import com.example.crèche.repositry.RessourcesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RessourcesService {
    private final RessourcesRepository ressourcesRepository;

    public RessourcesService(RessourcesRepository ressourcesRepository) {
        this.ressourcesRepository = ressourcesRepository;
    }

    public Ressources saveRessources(Ressources ressources) {
        return ressourcesRepository.save(ressources);
    }

    public void deleteRessources(Long id) {
        ressourcesRepository.deleteById(id);
    }

    public List<Ressources> getAllRessources() {
        return (List<Ressources>) ressourcesRepository.findAll();
    }

    public Ressources updateRessources(Long id, Ressources updatedRessources) {
        Optional<Ressources> existingRessourcesOptional = ressourcesRepository.findById(id);
        if (existingRessourcesOptional.isPresent()) {
            Ressources existingRessources = existingRessourcesOptional.get();
            existingRessources.setNbJeux(updatedRessources.getNbJeux());
            existingRessources.setTypeJeux(updatedRessources.getTypeJeux());
            return ressourcesRepository.save(existingRessources);
        } else {
            throw new RuntimeException("Ressources not found with id: " + id);
        }
    }
}
