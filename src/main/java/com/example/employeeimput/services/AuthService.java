package com.example.employeeimput.services;


import com.example.employeeimput.entities.User;
import com.example.employeeimput.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Value("${jwt.secret}")
    private String jwtSecret;
    @Autowired
     private UserRepository userRepository;
    private final UserDetailsService userDetailsService;

    public AuthService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String authenticate(String username, String password) {
        // Add your authentication logic here (e.g., checking credentials)
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        // If authentication is successful, generate JWT token
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }
    public String getUserRole(String username) {
        // Assuming you have a User entity with roles
        User user = userRepository.findByUsername(username);
        return user.getRole();  // Assuming 'getRole()' returns a string like "Admin" or "Employee"
    }
}
