package com.example.crèche.controller;

import com.example.crèche.model.Enfant;
import com.example.crèche.service.EnfantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enfants")
@CrossOrigin(origins = "*")
public class EnfantController {

    private final EnfantService enfantService;

    @Autowired
    public EnfantController(EnfantService enfantService) {
        this.enfantService = enfantService;
    }

    @PostMapping("/saveEnfant")
    public ResponseEntity<Enfant> saveEnfant(@RequestBody Enfant enfant) {
        Enfant savedEnfant = enfantService.saveEnfant(enfant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEnfant);
    }

    @GetMapping
    public List<Enfant> getAllEnfants() {
        return enfantService.getAllEnfants();
    }

    @DeleteMapping("/{id}")
    public void deleteEnfant(@PathVariable Long id) {
        enfantService.deleteEnfant(id);
    }

    @PutMapping("/{id}")
    public Enfant updateEnfant(@PathVariable Long id, @RequestBody Enfant enfantDetails) {
        return enfantService.updateEnfant(id, enfantDetails);
    }

    @GetMapping("/rechercher-par-nom")
    public List<Enfant> rechercherParNom(@RequestParam String nom) {
        return enfantService.rechercherParNom(nom);
    }

    // Route pour obtenir le nombre total d'enfants
    @GetMapping("/count")
    public ResponseEntity<Long> compterEnfants() {
        long count = enfantService.countEnfants();
        return ResponseEntity.ok(count);
    }

}

