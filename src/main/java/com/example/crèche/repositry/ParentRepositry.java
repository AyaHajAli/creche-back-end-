package com.example.crèche.repositry;

import com.example.crèche.model.Parent;
import com.example.crèche.model.User;
import org.springframework.data.repository.CrudRepository;

public interface ParentRepositry extends CrudRepository<Parent,Long> {

    Parent findByEmail(String email);


}
