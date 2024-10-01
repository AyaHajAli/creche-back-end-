package com.example.crèche.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Planning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;
    private LocalDate date;
    private LocalTime heureDeb;
    private LocalTime  heureFin;


    public Planning() {

    }
    @ManyToOne
    @JoinColumn(name = "activite")
    private Activite activite;
}
