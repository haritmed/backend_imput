package com.example.employeeimput.services;

import org.springframework.data.domain.Page;
import com.example.employeeimput.entities.Rapport;
import java.util.List;
public interface RapportService {
    Rapport saveRapport(Rapport rapport); //"Create" pour créer un nouveau client s'il nexiste pas id
    Rapport updateRapport(Rapport rapport);//"Update"
    void deleteRapportById(Long id);//"Delete by id"
    void deleteAllRapport();//"Delete All"
    Rapport getRapportById(Long id); //"Read by id"
    List<Rapport> getAllRapport();
    Page<Rapport> getAllRapportByPage(int page, int size);
}
