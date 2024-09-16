package com.example.employeeimput.services;

import com.example.employeeimput.entities.Equipe;
import com.example.employeeimput.repositories.EquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EquipeServiceImp implements EquipeService{
    @Autowired
    private EquipeRepository equipeRepository;
    @Override
    public Equipe saveEquipe(Equipe employee) {
        return equipeRepository.save(employee);
    }

    @Override
    public Equipe updateEquipe(Equipe employee) {
        return equipeRepository.save(employee);
    }

    @Override
    public void deleteEquipeById(Long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public void deleteAllEquipe() {
        equipeRepository.deleteAll();
    }

    @Override
    public Equipe getEquipeById(Long id) {
        return equipeRepository.findById(id).get();
    }

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Page<Equipe> getAllEquipeByPage(int page, int size) {
        return equipeRepository.findAll(PageRequest.of(page, size));
    }
}
