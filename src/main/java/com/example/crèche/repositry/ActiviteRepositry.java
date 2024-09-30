package com.example.crèche.repositry;

import com.example.crèche.model.Activite;
import org.springframework.data.repository.CrudRepository;

public interface ActiviteRepositry extends CrudRepository<Activite, Long> {
}
