package com.example.crèche.service;

import com.example.crèche.model.Reclamation;
import com.example.crèche.repositry.ReclamationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationService {
    private final ReclamationRepository reclamationRepository;

    public ReclamationService(ReclamationRepository reclamationRepository) {
        this.reclamationRepository = reclamationRepository;
    }

    public Reclamation saveReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    public void deleteReclamation(Long id) {
        reclamationRepository.deleteById(id);
    }

    public List<Reclamation> getAllReclamations() {
        return (List<Reclamation>) reclamationRepository.findAll();
    }

    public Reclamation updateReclamation(Long id, Reclamation updatedReclamation) {
        Optional<Reclamation> existingReclamationOptional = reclamationRepository.findById(id);
        if (existingReclamationOptional.isPresent()) {
            Reclamation existingReclamation = existingReclamationOptional.get();
            existingReclamation.setMessage(updatedReclamation.getMessage());
            existingReclamation.setName(updatedReclamation.getName());
            existingReclamation.setEmail(updatedReclamation.getEmail());
            return reclamationRepository.save(existingReclamation);
        } else {
            throw new RuntimeException("Reclamation not found with id: " + id);
        }
    }
}
