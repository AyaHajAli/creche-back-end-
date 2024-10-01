package com.example.crèche.controller;

import com.example.crèche.model.Admin;
import com.example.crèche.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
@CrossOrigin(origins = "http://localhost:52248")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }
    @PostMapping("/admin")
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmin();
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        return adminService.updateAdmin(id, adminDetails);
    }

}

