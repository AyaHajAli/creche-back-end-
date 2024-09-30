package com.example.crèche.controller;

import com.example.crèche.model.User;
import com.example.crèche.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController//type de classe
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:56844/")
public class UserController {
    private final UserService userservice;

    @Autowired
    public UserController(UserService userService, UserService userservice){
        this.userservice = userservice;

    }
    @PostMapping("save")
    public User saveUser(@RequestBody User user) {
        return userservice.saveUser(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userservice.getAllUsers();
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userservice.deleteUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userservice.updateUser(id, userDetails);
    }

}
