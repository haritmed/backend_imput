package com.example.employeeimput.services;

import com.example.employeeimput.entities.LotProjet;
import com.example.employeeimput.entities.Projet;
import com.example.employeeimput.repositories.LotProjetRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class LotProjetServiceImp implements LotProjetService {
    @Autowired
    private LotProjetRepository lotProjetRepository;
    @Override
    public LotProjet saveLotProjet(LotProjet lotProjet) {
        return lotProjetRepository.save(lotProjet);
    }

    @Override
    public LotProjet updateLotProjet(LotProjet lotProjet) {
        return lotProjetRepository.save(lotProjet);
    }

    @Override
    public void deleteLotProjetById(Long id) {
        lotProjetRepository.deleteById(id);
    }

    @Override
    public void deleteAllLotProjet() {
        lotProjetRepository.deleteAll();
    }

    @Override
    public LotProjet getLotProjetById(Long id) {
        return lotProjetRepository.findById(id).get();
    }

    @Override
    public List<LotProjet> getAllLotProjet() {
        return lotProjetRepository.findAll();
    }

    @Override
    public Page<LotProjet> getAllLotProjetByPage(int page, int size) {
        return lotProjetRepository.findAll(PageRequest.of(page, size));
    }
}
