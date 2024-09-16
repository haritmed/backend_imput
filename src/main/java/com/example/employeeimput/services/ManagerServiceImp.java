package com.example.employeeimput.services;

import com.example.employeeimput.entities.Manager;
import com.example.employeeimput.repositories.ManagerRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ManagerServiceImp implements ManagerService{
    @Autowired
    private ManagerRepository managerRepository;
    @Override
    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager updateManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public void deleteManagerById(Long id) {
        managerRepository.deleteById(id);
    }

    @Override
    public void deleteAllManager() {
        managerRepository.deleteAll();
    }

    @Override
    public Manager getManagerById(Long id) {
        return managerRepository.findById(id).get();
    }

    @Override
    public List<Manager> getAllManager() {
        return managerRepository.findAll();
    }

    @Override
    public Page<Manager> getAllManagerByPage(int page, int size) {
        return managerRepository.findAll(PageRequest.of(page, size));
    }
}
