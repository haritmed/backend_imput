package com.example.employeeimput.controllers;

public class AuthResponse {

    private String jwt;
    private String role;
    public AuthResponse() {
    }

    public AuthResponse(String jwt, String role) {
        this.jwt = jwt;
        this.role=role;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

