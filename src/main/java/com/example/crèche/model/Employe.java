package com.example.crèche.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employe extends User {

    private String poste;
    private Double salaire;



    public Employe(String nom, String prenom,String username, String email, String encode, String adresse, String telephone, String poste, Double salaire) {
        super(nom , prenom , username , email , encode , adresse , telephone);
        this.poste = poste;
        this.salaire = salaire;
    }
    @ManyToOne
    @JoinColumn(name = "groupe")
    private Groupe groupe;



}

