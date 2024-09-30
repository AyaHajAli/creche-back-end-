package com.example.crèche.service;

import com.example.crèche.model.Planning;
import com.example.crèche.repositry.PlanningRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanningService {
    private final PlanningRepository planningRepository;

    public PlanningService(PlanningRepository planningRepository) {
        this.planningRepository = planningRepository;
    }

    public Planning savePlanning(Planning planning) {
        return planningRepository.save(planning);
    }

    public void deletePlanning(Long id) {
        planningRepository.deleteById(id);
    }

    public List<Planning> getAllPlannings() {
        return (List<Planning>) planningRepository.findAll();
    }

    public Planning updatePlanning(Long id, Planning updatedPlanning) {
        Optional<Planning> existingPlanningOptional = planningRepository.findById(id);
        if (existingPlanningOptional.isPresent()) {
            Planning existingPlanning = existingPlanningOptional.get();
            existingPlanning.setDate(updatedPlanning.getDate());
            existingPlanning.setHeureDeb(updatedPlanning.getHeureDeb());
            existingPlanning.setHeureFin(updatedPlanning.getHeureFin());
            return planningRepository.save(existingPlanning);
        } else {
            throw new RuntimeException("Planning not found with id: " + id);
        }
    }
}
