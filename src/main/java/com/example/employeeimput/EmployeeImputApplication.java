package com.example.employeeimput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.employeeimput.entities")
public class EmployeeImputApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeImputApplication.class, args);
    }
}

