package com.example.crèche.service;

import com.example.crèche.model.Admin;
import com.example.crèche.model.Employe;
import com.example.crèche.model.Parent;
import com.example.crèche.model.registerDto;
import com.example.crèche.repositry.AdminRepositry;
import com.example.crèche.repositry.EmployeRepositry;
import com.example.crèche.repositry.ParentRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegisterService {

    private final ParentRepositry parentRepository;
    private final AdminRepositry adminRepository;
    private final EmployeRepositry employeRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public RegisterService(ParentRepositry parentRepository, AdminRepositry adminRepository, EmployeRepositry employeRepository, PasswordEncoder passwordEncoder) {
        this.parentRepository = parentRepository;
        this.adminRepository = adminRepository;
        this.employeRepository = employeRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void inscrireUtilisateur(registerDto registerDto) {
        if ("parent".equalsIgnoreCase(registerDto.getRole())) {
            inscrireParent(registerDto);
        } else if ("employe".equalsIgnoreCase(registerDto.getRole())) {
            inscrireEmploye(registerDto);
        } else if ("admin".equalsIgnoreCase(registerDto.getRole())) {
            inscrireAdmin(registerDto);
        } else {
            throw new IllegalArgumentException("Rôle non valide pour l'inscription.");
        }
    }

    private void inscrireParent(registerDto registerDto) {
        Parent parent = new Parent(registerDto.getNom(), registerDto.getPrenom(), registerDto.getUsername(),
                registerDto.getEmail(), passwordEncoder.encode(registerDto.getPassword()),
                registerDto.getAdresse(), registerDto.getTelephone(), registerDto.getFidelite());

        parentRepository.save(parent);
    }

    private void inscrireEmploye(registerDto registerDto) {
        Employe babysitter = new Employe(registerDto.getNom(), registerDto.getPrenom(), registerDto.getUsername(),
                registerDto.getEmail(), passwordEncoder.encode(registerDto.getPassword()),
                registerDto.getAdresse(), registerDto.getTelephone(),
                registerDto.getPoste(), registerDto.getSalaire());

        employeRepository.save(babysitter);
    }

    private void inscrireAdmin(registerDto registerDto) {
        Admin admin = new Admin(registerDto.getNom(), registerDto.getPrenom(), registerDto.getUsername(),
                registerDto.getEmail(), passwordEncoder.encode(registerDto.getPassword()),
                registerDto.getAdresse(), registerDto.getTelephone());

        adminRepository.save(admin);
    }

    public registerDto connecterUtilisateur(registerDto registerDto) {
        // Ajouter la logique de connexion ici
        // Vérifier les informations d'identification, comparer les mots de passe, etc.
        Parent parent = parentRepository.findByEmail(registerDto.getEmail());
        if (parent != null && passwordEncoder.matches(registerDto.getPassword(), parent.getPassword())) {
            registerDto.setRole("parent");
            registerDto.setUsername(parent.getUsername());
            registerDto.setNom(parent.getNom());
            registerDto.setPrenom(parent.getPrenom());
            registerDto.setEmail(parent.getEmail());
            registerDto.setTelephone(parent.getTelephone());
            registerDto.setAdresse(parent.getAdresse());
            registerDto.setId(parent.getId());
            registerDto.setFidelite(parent.getFidelite());
            return registerDto;
        }

        Admin admin = adminRepository.findByEmail(registerDto.getEmail());
        if (admin != null && passwordEncoder.matches(registerDto.getPassword(), admin.getPassword())) {
            registerDto.setRole("admin");
            registerDto.setTelephone(admin.getTelephone());
            registerDto.setNom(admin.getNom());
            registerDto.setPrenom(admin.getPrenom());
            registerDto.setAdresse(admin.getAdresse());
            registerDto.setUsername(admin.getUsername());
            registerDto.setEmail(admin.getEmail());
            registerDto.setId(admin.getId());
            return registerDto;
        }
        Employe employe = employeRepository.findByEmail(registerDto.getEmail());
        if (employe != null && passwordEncoder.matches(registerDto.getPassword(), employe.getPassword())) {
            registerDto.setRole("employe");
            registerDto.setTelephone(employe.getTelephone());
            registerDto.setNom(employe.getNom());
            registerDto.setPrenom(employe.getPrenom());
            registerDto.setAdresse(employe.getAdresse());
            registerDto.setUsername(employe.getUsername());
            registerDto.setEmail(employe.getEmail());
            registerDto.setId(employe.getId());
            registerDto.setPoste(employe.getPoste());
            registerDto.setSalaire(employe.getSalaire());
            return registerDto;
        }
        return registerDto;
    }
}