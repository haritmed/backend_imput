package com.example.employeeimput.services;


import com.example.employeeimput.entities.LotProjet;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LotProjetService {
    LotProjet saveLotProjet(LotProjet lotProjet); //"Create" pour créer un nouveau client s'il nexiste pas id
    LotProjet updateLotProjet(LotProjet lotProjet);//"Update"
    void deleteLotProjetById(Long id);//"Delete by id"
    void deleteAllLotProjet();//"Delete All"
    LotProjet getLotProjetById(Long id); //"Read by id"
    List<LotProjet> getAllLotProjet();
    Page<LotProjet> getAllLotProjetByPage(int page, int size);
}
