package com.example.crèche.controller;

import com.example.crèche.model.Planning;
import com.example.crèche.service.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plannings")
public class PlanningController {
    private final PlanningService planningService;

    @Autowired
    public PlanningController(PlanningService planningService) {
        this.planningService = planningService;
    }

    public Planning savePlanning(@RequestBody Planning planning) {
        return planningService.savePlanning(planning);
    }

    @GetMapping
    public List<Planning> getAllPlannings() {
        return planningService.getAllPlannings();
    }

    @DeleteMapping("/{id}")
    public void deletePlanning(@PathVariable Long id) {
        planningService.deletePlanning(id);
    }

    @PutMapping("/{id}")
    public Planning updatePlanning(@PathVariable Long id, @RequestBody Planning planningDetails) {
        return planningService.updatePlanning(id, planningDetails);
    }
}
