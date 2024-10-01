package com.example.crèche.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parent extends User {
    private String fidelite;


    public Parent(String nom, String prenom,String username, String email, String encode, String adresse, String telephone, String fidelite) {
        super(nom , prenom , username , email , encode , adresse , telephone);
        this.fidelite = fidelite;
    }
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Enfant> EnfantList;

    @ManyToOne
    @JoinColumn(name = "inscripition")
    private Inscription inscripition;
    @ManyToOne
    @JoinColumn(name = "reclamation")
    private Reclamation reclamation;






}