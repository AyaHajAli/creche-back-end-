package com.example.crèche.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;
    private String message;
    private String email;
    private String name;



    public Reclamation() {

    }
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Parent> parentList;
}
