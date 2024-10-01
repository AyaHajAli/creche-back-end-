package com.example.crèche.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Admin extends User {

    public Admin(String nom, String prenom, String username, String email, String encode, String adresse, String telephone) {
        super(nom , prenom , username , email , encode , adresse , telephone);

    }


    @ManyToOne
    @JoinColumn(name = "ressource")
    private Ressources ressources;



}