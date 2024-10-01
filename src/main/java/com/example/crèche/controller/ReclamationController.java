package com.example.crèche.controller;

import com.example.crèche.model.Reclamation;
import com.example.crèche.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamations")
@CrossOrigin(origins = "*")
public class ReclamationController {
    private final ReclamationService reclamationService;

    @Autowired
    public ReclamationController(ReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }
    @PostMapping("/msg")
    public Reclamation saveReclamation(@RequestBody Reclamation reclamation) {
        System.out.println("Received feedback: " + reclamation);
        return reclamationService.saveReclamation(reclamation);
    }

    @GetMapping
    public List<Reclamation> getAllReclamations() {
        return reclamationService.getAllReclamations();
    }

    @DeleteMapping("/{id}")
    public void deleteReclamation(@PathVariable Long id) {
        reclamationService.deleteReclamation(id);
    }

    @PutMapping("/{id}")
    public Reclamation updateReclamation(@PathVariable Long id, @RequestBody Reclamation reclamationDetails) {
        return reclamationService.updateReclamation(id, reclamationDetails);
    }
}
