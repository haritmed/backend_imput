package com.example.employeeimput.services;

import com.example.employeeimput.entities.Rapport;

import com.example.employeeimput.repositories.RapportRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RapportServiceImp implements RapportService{
    @Autowired
    private RapportRepository rapportRepository;
    @Override
    public Rapport saveRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    @Override
    public Rapport updateRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    @Override
    public void deleteRapportById(Long id) {
        rapportRepository.deleteById(id);
    }

    @Override
    public void deleteAllRapport() {
        rapportRepository.deleteAll();
    }

    @Override
    public Rapport getRapportById(Long id) {
        return rapportRepository.findById(id).get();
    }

    @Override
    public List<Rapport> getAllRapport() {
        return rapportRepository.findAll();
    }

    @Override
    public Page<Rapport> getAllRapportByPage(int page, int size) {
        return rapportRepository.findAll(PageRequest.of(page, size));
    }
}
