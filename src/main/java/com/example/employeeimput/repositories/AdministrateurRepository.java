package com.example.employeeimput.repositories;

import com.example.employeeimput.entities.Administrateur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur,Long> {
}
