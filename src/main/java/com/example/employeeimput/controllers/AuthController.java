package com.example.employeeimput.controllers;

import com.example.employeeimput.entities.Administrateur;
import com.example.employeeimput.services.AdminServiceImp;
import com.example.employeeimput.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest loginRequest) {
        String token = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (token != null) {
            // Fetch the user's role from the authentication service or database
            String role = authService.getUserRole(loginRequest.getUsername());

            // Return both the token and role in the response
            return ResponseEntity.ok(new AuthResponse(token, role));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}