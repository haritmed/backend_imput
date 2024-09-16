package com.example.employeeimput.services;

import com.example.employeeimput.entities.Administrateur;
import com.example.employeeimput.repositories.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp {

    @Autowired
    private AdministrateurRepository adminRepository; // Assuming you have a repository

    public Administrateur getAdmin() {
        // Fetch the single admin from the repository
        return adminRepository.findById(1L) // Assuming admin ID is 1
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }
}

