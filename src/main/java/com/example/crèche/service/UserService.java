package com.example.crèche.service;

import com.example.crèche.model.User;
import com.example.crèche.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepositry userRepository;
@Autowired//appel lel annotation
    public UserService(UserRepositry userRepositry){
        this.userRepository=userRepositry;
}
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setNom(updatedUser.getNom());
            existingUser.setPrenom(updatedUser.getPrenom());
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setAdresse(updatedUser.getAdresse());
            existingUser.setTelephone(updatedUser.getTelephone());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

}