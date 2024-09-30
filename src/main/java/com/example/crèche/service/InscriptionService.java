package com.example.crèche.service;

import com.example.crèche.model.Inscription;
import com.example.crèche.repositry.InscriptionRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {
    private final InscriptionRepositry inscriptionRepository;

    public InscriptionService(InscriptionRepositry inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    public Inscription saveInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    public void deleteInscription(Integer id) {
        inscriptionRepository.deleteById(id);
    }

    public List<Inscription> getAllInscriptions() {
        return (List<Inscription>) inscriptionRepository.findAll();
    }

    public Inscription updateInscription(Integer id, Inscription updatedInscription) {
        Optional<Inscription> existingInscriptionOptional = inscriptionRepository.findById(id);
        if (existingInscriptionOptional.isPresent()) {
            Inscription existingInscription = existingInscriptionOptional.get();
            existingInscription.setMontant(updatedInscription.getMontant());
            existingInscription.setMode(updatedInscription.getMode());
            existingInscription.setDescription(updatedInscription.getDescription());
            return inscriptionRepository.save(existingInscription);
        } else {
            throw new RuntimeException("Inscription not found with id: " + id);
        }
    }
}
