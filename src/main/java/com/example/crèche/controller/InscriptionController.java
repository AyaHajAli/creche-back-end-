package com.example.crèche.controller;

import com.example.crèche.model.Inscription;
import com.example.crèche.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {
    private final InscriptionService inscriptionService;

    @Autowired
    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    public Inscription saveInscription(@RequestBody Inscription inscription) {
        return inscriptionService.saveInscription(inscription);
    }

    @GetMapping
    public List<Inscription> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }

    @DeleteMapping("/{id}")
    public void deleteInscription(@PathVariable Integer id) {
        inscriptionService.deleteInscription(id);
    }

    @PutMapping("/{id}")
    public Inscription updateInscription(@PathVariable Integer id, @RequestBody Inscription inscriptionDetails) {
        return inscriptionService.updateInscription(id, inscriptionDetails);
    }
}
