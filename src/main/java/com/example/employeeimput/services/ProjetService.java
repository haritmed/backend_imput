package com.example.employeeimput.services;

import com.example.employeeimput.dto.ProjetDto;
import com.example.employeeimput.entities.Manager;
import com.example.employeeimput.entities.Projet;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProjetService {
    Projet saveProjet(Projet projet);
    ProjetDto updateProjet(Long id ,ProjetDto projet);//"Update"
    void deleteProjetById(Long id);//"Delete by id"
    void deleteAllProjet();//"Delete All"
    ProjetDto getProjetById(Long id); //"Read by id"
    List<ProjetDto> getAllProjet();
    Page<ProjetDto> getAllProjetByPage(int page, int size);
}
