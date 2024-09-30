package com.example.crèche.controller;

import com.example.crèche.model.Activite;
import com.example.crèche.service.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activites")
public class ActiviteController {
    private final ActiviteService activiteService;

    @Autowired
    public ActiviteController(ActiviteService activiteService) {
        this.activiteService = activiteService;
    }

    public Activite saveActivite(@RequestBody Activite activite) {
        return activiteService.saveActivite(activite);
    }

    @GetMapping
    public List<Activite> getAllActivites() {
        return activiteService.getAllActivites();
    }

    @DeleteMapping("/{id}")
    public void deleteActivite(@PathVariable Long id) {
        activiteService.deleteActivite(id);
    }

    @PutMapping("/{id}")
    public Activite updateActivite(@PathVariable Long id, @RequestBody Activite activiteDetails) {
        return activiteService.updateActivite(id, activiteDetails);
    }
}
