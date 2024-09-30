package com.example.crèche.controller;

import com.example.crèche.model.Ressources;
import com.example.crèche.service.RessourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ressources")
public class RessourcesController {
    private final RessourcesService ressourcesService;

    @Autowired
    public RessourcesController(RessourcesService ressourcesService) {
        this.ressourcesService = ressourcesService;
    }

    public Ressources saveRessources(@RequestBody Ressources ressources) {
        return ressourcesService.saveRessources(ressources);
    }

    @GetMapping
    public List<Ressources> getAllRessources() {
        return ressourcesService.getAllRessources();
    }

    @DeleteMapping("/{id}")
    public void deleteRessources(@PathVariable Long id) {
        ressourcesService.deleteRessources(id);
    }

    @PutMapping("/{id}")
    public Ressources updateRessources(@PathVariable Long id, @RequestBody Ressources ressourcesDetails) {
        return ressourcesService.updateRessources(id, ressourcesDetails);
    }
}
