package com.example.employeeimput.services;

import com.example.employeeimput.entities.GestionnaireDeProfile;
import com.example.employeeimput.entities.Imputation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GestionnaireService {
    GestionnaireDeProfile saveGestionnaire(GestionnaireDeProfile gestionnaire); //"Create" pour créer un nouveau client s'il nexiste pas id
    GestionnaireDeProfile updateGestionnaire(GestionnaireDeProfile gestionnaire);//"Update"
    void deleteGestionnaireById(Long id);//"Delete by id"
    void deleteAllGestionnaire();//"Delete All"
    GestionnaireDeProfile getGestionnaireById(Long id); //"Read by id"
    List<GestionnaireDeProfile> getAllGestionnaire();
    Page<GestionnaireDeProfile> getAllGestionnaireByPage(int page, int size);
}
