package com.example.employeeimput.mapper;


import com.example.employeeimput.dto.ProjetDto;

import com.example.employeeimput.entities.Projet;

public class ProjetMapper {
    public static ProjetDto mapToProjetDto(Projet projet){
        return new ProjetDto(
                projet.getId(),
                projet.getNom(),
                projet.getBudgetTotal(),
                projet.getHeuresAllouees()
        );
    }

    public static Projet mapToProjet(ProjetDto projetDto){
        return new Projet(
                projetDto.getId(),
                projetDto.getNom(),
                projetDto.getBudgetTotal(),
                projetDto.getHeuresAllouees()
        );
    }
}
