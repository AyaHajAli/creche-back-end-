package com.example.crèche.controller;

import com.example.crèche.model.registerDto;
import com.example.crèche.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class inscrireController {

    private final RegisterService registerService;

    @Autowired
    public inscrireController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/registre")
    public ResponseEntity<String> inscrireUtilisateur(@RequestBody registerDto registerDto) {
        registerService.inscrireUtilisateur(registerDto);
        return ResponseEntity.ok("Inscription réussie.");
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> connecterUtilisateur(@RequestBody registerDto registerDto) {
        registerDto utilisateurConnecte = registerService.connecterUtilisateur(registerDto);
        Map<String, Object> response = new HashMap<>();

        if (utilisateurConnecte.getRole() != null) {
            response.put("success", "true");
            response.put("role", utilisateurConnecte.getRole());

            // Ajouter les coordonnées en fonction du rôle
            Map<String, String> coordonnees = new HashMap<>();
            coordonnees.put("nom", utilisateurConnecte.getNom());
            coordonnees.put("prenom", utilisateurConnecte.getPrenom());
            coordonnees.put("adresse", utilisateurConnecte.getAdresse());
            coordonnees.put("telephone", utilisateurConnecte.getTelephone());
            coordonnees.put("email", utilisateurConnecte.getEmail());

            // Ajouter les coordonnées spécifiques en fonction du rôle
            if ("employe".equals(utilisateurConnecte.getRole())) {
                coordonnees.put("poste", utilisateurConnecte.getPoste());
                coordonnees.put("salaire", utilisateurConnecte.getSalaire().toString());
            } else if ("parent".equals(utilisateurConnecte.getRole())) {
                coordonnees.put("fidelite", utilisateurConnecte.getFidelite().toString());
            }

            response.put("coordonnees", coordonnees);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", "false");
            return ResponseEntity.badRequest().body(response);
        }
    }
}




