package com.example.crèche.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;
    private String nom;


    public Activite() {

    }
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Groupe> GroupeList;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Planning> planningList;
    @ManyToOne
    @JoinColumn(name = "ressource")
    private Ressources ressources;

}

