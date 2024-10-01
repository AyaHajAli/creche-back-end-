package com.example.crèche.repositry;

import com.example.crèche.model.Employe;
import org.springframework.data.repository.CrudRepository;

public interface EmployeRepositry extends CrudRepository<Employe,Long> {
    Employe findByEmail(String email);
}
