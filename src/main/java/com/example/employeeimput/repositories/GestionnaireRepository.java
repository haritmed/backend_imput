package com.example.employeeimput.repositories;

import com.example.employeeimput.entities.GestionnaireDeProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestionnaireRepository extends JpaRepository<GestionnaireDeProfile,Long> {
}
