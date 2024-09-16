package com.example.employeeimput.services;

import com.example.employeeimput.entities.GestionnaireDeProfile;
import com.example.employeeimput.repositories.GestionnaireRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class GestionnaireServiceImp implements GestionnaireService{
    @Autowired
    private GestionnaireRepository gestionnaireRepository;
    @Override
    public GestionnaireDeProfile saveGestionnaire(GestionnaireDeProfile employee) {
        return gestionnaireRepository.save(employee);
    }

    @Override
    public GestionnaireDeProfile updateGestionnaire(GestionnaireDeProfile employee) {
        return gestionnaireRepository.save(employee);
    }

    @Override
    public void deleteGestionnaireById(Long id) {
        gestionnaireRepository.deleteById(id);
    }

    @Override
    public void deleteAllGestionnaire() {
        gestionnaireRepository.deleteAll();
    }

    @Override
    public GestionnaireDeProfile getGestionnaireById(Long id) {
        return gestionnaireRepository.findById(id).get();
    }

    @Override
    public List<GestionnaireDeProfile> getAllGestionnaire() {
        return gestionnaireRepository.findAll();
    }

    @Override
    public Page<GestionnaireDeProfile> getAllGestionnaireByPage(int page, int size) {
        return gestionnaireRepository.findAll(PageRequest.of(page, size));
    }
}
