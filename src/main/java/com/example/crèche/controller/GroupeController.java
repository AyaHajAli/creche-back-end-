package com.example.crèche.controller;

import com.example.crèche.model.Groupe;
import com.example.crèche.service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupes")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupeController {
    private final GroupeService groupeService;

    @Autowired
    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }
    @PostMapping("save")
    public Groupe saveGroupe(@RequestBody Groupe groupe) {
        return groupeService.saveGroupe(groupe);
    }

    @GetMapping
    public List<Groupe> getAllGroupes() {
        return groupeService.getAllGroupes();
    }

    @DeleteMapping("/{id}")
    public void deleteGroupe(@PathVariable Integer id) {
        groupeService.deleteGroupe(id);
    }

    @PutMapping("/{id}")
    public Groupe updateGroupe(@PathVariable Integer id, @RequestBody Groupe groupeDetails) {
        return groupeService.updateGroupe(id, groupeDetails);
    }
}
