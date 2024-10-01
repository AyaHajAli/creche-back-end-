package com.example.crèche.repositry;

import com.example.crèche.model.Enfant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnfantRepositry extends CrudRepository<Enfant,Long> {

    List<Enfant> findByNom(String nom);
}

