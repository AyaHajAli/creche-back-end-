package com.example.crèche.service;

import com.example.crèche.model.Groupe;
import com.example.crèche.repositry.GroupeRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupeService {
    private final GroupeRepositry groupeRepositry;

    public GroupeService(GroupeRepositry groupeRepositry) {
        this.groupeRepositry = groupeRepositry;
    }

    public Groupe saveGroupe(Groupe groupe) {
        return groupeRepositry.save(groupe);
    }

    public void deleteGroupe(Integer id) {
        groupeRepositry.deleteById(id);
    }

    public List<Groupe> getAllGroupes() {
        return (List<Groupe>) groupeRepositry.findAll();
    }

    public Groupe updateGroupe(Integer id, Groupe updatedGroupe) {
        Optional<Groupe> existingGroupeOptional = groupeRepositry.findById(id);
        if (existingGroupeOptional.isPresent()) {
            Groupe existingGroupe = existingGroupeOptional.get();
            existingGroupe.setNom(updatedGroupe.getNom());
            existingGroupe.setNbEnfants(updatedGroupe.getNbEnfants());
            return groupeRepositry.save(existingGroupe);
        } else {
            throw new RuntimeException("Groupe not found with id: " + id);
        }
    }
}
