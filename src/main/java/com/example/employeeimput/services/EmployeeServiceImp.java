package com.example.employeeimput.services;

import com.example.employeeimput.dto.EmployeeDto;
import com.example.employeeimput.dto.ProjetDto;
import com.example.employeeimput.entities.Employee;
import com.example.employeeimput.entities.Equipe;
import com.example.employeeimput.entities.Projet;
import com.example.employeeimput.exceptions.ResourceNotFoundException;
import com.example.employeeimput.mapper.EmployeeMapper;
import com.example.employeeimput.mapper.ProjetMapper;
import com.example.employeeimput.repositories.EmployeeRepository;
import com.example.employeeimput.repositories.ProjetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
         Employee savedEmployee =employeeRepository.save(employee);
         return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employee) {
       Employee employee1 =employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with given id"+id)
        );
       employee1.setFirstName(employee.getFirstName());
       employee1.setLastName(employee.getLastName());
       employee1.setEmail(employee.getEmail());
       employee1.setHourWorked(employee.getHourWorked());
        Employee updatedEmployee= employeeRepository.save(employee1);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee =employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exist with given id"+id)
        );
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAllEmployee() {
        employeeRepository.deleteAll();
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee is not found with given id:"+id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees=employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public Page<Employee> getAllEmployeeByPage(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page, size));
    }



    @Override
    public List<ProjetDto> getEmployeeProjects(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id: " + employeeId)
        );
        List<Projet> projects = employee.getProjects(); // Get projects from employee
        return projects.stream()
                .map(ProjetMapper::mapToProjetDto) // Map Projet to ProjectDto
                .collect(Collectors.toList());
    }

    @Override
    public Equipe getEmployeeTeam(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee not found with id: " + employeeId)
        );
        Equipe team = employee.getEquipe(); // Get team from employee
        return team;
    }
}
