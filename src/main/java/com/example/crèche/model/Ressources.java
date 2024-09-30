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
public class Ressources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;
    private int nbJeux;
    private  String typeJeux;



    public Ressources() {

    }
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Activite> ActiviteList;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Admin> AdminList;


}
