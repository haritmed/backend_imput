package com.example.employeeimput.services;


import com.example.employeeimput.entities.Equipe;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EquipeService {
    Equipe saveEquipe(Equipe equipe); //"Create" pour créer un nouveau client s'il nexiste pas id
    Equipe updateEquipe(Equipe equipe);//"Update"
    void deleteEquipeById(Long id);//"Delete by id"
    void deleteAllEquipe();//"Delete All"
    Equipe getEquipeById(Long id); //"Read by id"
    List<Equipe> getAllEquipe();
    Page<Equipe> getAllEquipeByPage(int page, int size);
}
