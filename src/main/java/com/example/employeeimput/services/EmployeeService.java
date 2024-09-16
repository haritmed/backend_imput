package com.example.employeeimput.services;

import com.example.employeeimput.dto.EmployeeDto;
import com.example.employeeimput.dto.ProjetDto;
import com.example.employeeimput.entities.Employee;
import com.example.employeeimput.entities.Equipe;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto); //"Create" pour créer un nouveau client s'il nexiste pas id
    EmployeeDto updateEmployee(Long id, EmployeeDto employee);//"Update"
    void deleteEmployee(Long id);//"Delete by id"
    void deleteAllEmployee();//"Delete All"
    EmployeeDto getEmployeeById(Long id); //"Read by id"
    List<EmployeeDto> getAllEmployee();
    Page<Employee> getAllEmployeeByPage(int page, int size);

    List<ProjetDto> getEmployeeProjects(Long employeeId);
    Equipe getEmployeeTeam(Long employeeId);
}
