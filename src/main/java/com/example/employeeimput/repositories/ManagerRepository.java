package com.example.employeeimput.repositories;


import com.example.employeeimput.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
}
