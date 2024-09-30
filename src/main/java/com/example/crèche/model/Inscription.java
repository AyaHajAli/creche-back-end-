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
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;
    private double montant;
    private String mode;
    private String description;


    public Inscription() {

    }
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Parent> ParentList;
}
