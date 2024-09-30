package com.example.crèche.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;
    private String nom;
    private int nbEnfants;


    public Groupe() {

    }
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Employe> EmployeList;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "enfant")
    private Enfant EnfatList;}
