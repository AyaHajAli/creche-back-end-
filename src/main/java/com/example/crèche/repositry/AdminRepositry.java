package com.example.crèche.repositry;

import com.example.crèche.model.Admin;
import com.example.crèche.model.Parent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositry extends CrudRepository<Admin,Long> {
    Admin findByEmail(String email);
}
