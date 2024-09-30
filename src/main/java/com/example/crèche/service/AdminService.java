package com.example.crèche.service;

import com.example.crèche.model.Admin;
import com.example.crèche.repositry.AdminRepositry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private AdminRepositry adminRepositry;

   public AdminService(AdminRepositry adminRepositry){
       this.adminRepositry=adminRepositry;
   }
    public Admin saveAdmin(Admin admin){
       return adminRepositry.save(admin);
    }
    public void deleteAdmin(Long id){
       adminRepositry.deleteById(id);
    }
    public List<Admin> getAllAdmin(){
       return (List<Admin>) adminRepositry.findAll();
    }
    public Admin updateAdmin(Long id, Admin updatedAdmin){
       Optional<Admin> existingAdminOptional= adminRepositry.findById(id);
       if(existingAdminOptional.isPresent()){
           Admin existingAdmin=existingAdminOptional.get();
           existingAdmin.setNom(updatedAdmin.getNom());
           existingAdmin.setPrenom(updatedAdmin.getPrenom());
           existingAdmin.setUsername(updatedAdmin.getUsername());
           existingAdmin.setEmail(updatedAdmin.getEmail());
           existingAdmin.setPassword(updatedAdmin.getPassword());
           existingAdmin.setAdresse(updatedAdmin.getAdresse());
           existingAdmin.setTelephone(updatedAdmin.getTelephone());
           return adminRepositry.save(existingAdmin);
       } else {
           throw new RuntimeException("Admin not found with id: " + id);
       }
    }
    public long countEnfants() {
        return adminRepositry.count();
    }


}


