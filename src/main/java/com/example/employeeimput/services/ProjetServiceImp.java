package com.example.employeeimput.services;


import com.example.employeeimput.dto.ProjetDto;

import com.example.employeeimput.entities.Event;
import com.example.employeeimput.entities.Projet;

import com.example.employeeimput.exceptions.ResourceNotFoundException;

import com.example.employeeimput.mapper.ProjetMapper;
import com.example.employeeimput.repositories.ProjetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjetServiceImp implements ProjetService {
    @Autowired
    private ProjetRepository projetRepository;
    @Override
    public Projet saveProjet(Projet event) {
        return projetRepository.save(event);
    }

    @Override
    public ProjetDto updateProjet(Long id, ProjetDto projet) {
        Projet projet1 =projetRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Project does not exist with given id"+id)
        );
        projet1.setNom(projet.getNom());
        projet1.setBudgetTotal(projet.getBudgetTotal());
        projet1.setHeuresAllouees(projet.getHeuresAllouees());
        Projet updatedProjet= projetRepository.save(projet1);
        return ProjetMapper.mapToProjetDto(updatedProjet);
    }

    @Override
    public void deleteProjetById(Long id) {
        projetRepository.deleteById(id);
    }

    @Override
    public void deleteAllProjet() {
        projetRepository.deleteAll();
    }

    @Override
    public ProjetDto getProjetById(Long id) {
        Projet projet=projetRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Projetc is not found with given id:"+id));
        return ProjetMapper.mapToProjetDto(projet);
    }

    @Override
    public List<ProjetDto> getAllProjet() {
        List<Projet> projets=projetRepository.findAll();

        return projets.stream().map((projet) -> ProjetMapper.mapToProjetDto(projet))
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProjetDto> getAllProjetByPage(int page, int size) {
        return null;
    }

}
