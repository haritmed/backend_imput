package com.example.employeeimput.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjetDto {
    private Long id;
    private String nom;
    private double budgetTotal;
    private Integer heuresAllouees;
}
