package com.example.crèche.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enfant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Long age;
    private String genre;

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Nom: " + nom + "\n" +
                "Prénom: " + prenom + "\n" +
                "Date de Naissance: " + dateNaissance + "\n" +
                "Age: " + age + "\n" +
                "Genre: " + genre + "\n" +
                "Parent: " + (parent != null ? parent.getId() : "Aucun parent");
    }


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "parent")
    private Parent parent;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Groupe> groupeList; // mappedBy devrait correspondre au nom de la propriété dans Groupe
}
