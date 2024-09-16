package com.example.employeeimput.services;

import com.example.employeeimput.entities.Employee;
import com.example.employeeimput.entities.Manager;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ManagerService {
    Manager saveManager(Manager manager); //"Create" pour créer un nouveau client s'il nexiste pas id
    Manager updateManager(Manager manager);//"Update"
    void deleteManagerById(Long id);//"Delete by id"
    void deleteAllManager();//"Delete All"
    Manager getManagerById(Long id); //"Read by id"
    List<Manager> getAllManager();
    Page<Manager> getAllManagerByPage(int page, int size);
}
