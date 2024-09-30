package com.example.crèche.controller;

import com.example.crèche.model.Parent;
import com.example.crèche.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
public class ParentController {
    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    public Parent saveParent(@RequestBody Parent parent) {
        return parentService.saveParent(parent);
    }

    @GetMapping
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

    @DeleteMapping("/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
    }

    @PutMapping("/{id}")
    public Parent updateParent(@PathVariable Long id, @RequestBody Parent parentDetails) {
        return parentService.updateParent(id, parentDetails);
    }
}
