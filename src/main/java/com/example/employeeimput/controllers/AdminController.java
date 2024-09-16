package com.example.employeeimput.controllers;

import com.example.employeeimput.entities.Administrateur;
import com.example.employeeimput.services.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminServiceImp adminService; // Assuming you have a service to handle business logic

    @GetMapping("/profile")
    public Administrateur getAdminProfile() {
        // Fetch the single admin from the service
        return adminService.getAdmin(); // Adjust method as necessary
    }
}

