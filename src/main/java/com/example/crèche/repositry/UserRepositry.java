package com.example.crèche.repositry;

import com.example.crèche.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface UserRepositry extends CrudRepository   <User,Long> {


}
