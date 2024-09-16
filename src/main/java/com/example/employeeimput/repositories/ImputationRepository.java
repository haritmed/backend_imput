package com.example.employeeimput.repositories;


import com.example.employeeimput.entities.Imputation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImputationRepository extends JpaRepository<Imputation,Long> {
}
