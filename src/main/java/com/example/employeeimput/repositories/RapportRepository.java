package com.example.employeeimput.repositories;


import com.example.employeeimput.entities.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RapportRepository extends JpaRepository<Rapport,Long> {
}
