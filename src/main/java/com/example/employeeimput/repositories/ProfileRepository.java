package com.example.employeeimput.repositories;


import com.example.employeeimput.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    Profile findByName(String name);
}
