package com.example.employeeimput.controllers;

import com.example.employeeimput.dto.EmployeeDto;

import com.example.employeeimput.dto.ProjetDto;
import com.example.employeeimput.entities.Employee;
import com.example.employeeimput.entities.Equipe;
import com.example.employeeimput.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //build add employee rest api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeHours(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        EmployeeDto employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            employee.setHourWorked(updatedEmployee.getHourWorked());
            employeeService.saveEmployee(employee);
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //build get employee rest api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
        EmployeeDto employeeDto=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDto);
    }
    // build get all employees rest api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getAllEmployees(){
        List<EmployeeDto> employees =employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    // build update employee rest api


    //build delete employee rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully!!");
    }

    // New endpoint to get projects for the employee
    @GetMapping("/{id}/projects")
    public ResponseEntity<List<ProjetDto>> getEmployeeProjects(@PathVariable("id") Long id) {
        List<ProjetDto> projects = employeeService.getEmployeeProjects(id);
        return ResponseEntity.ok(projects);
    }

    // New endpoint to get team details for the employee
    @GetMapping("/{id}/team")
    public ResponseEntity<Equipe> getEmployeeTeam(@PathVariable("id") Long id) {
        Equipe team = employeeService.getEmployeeTeam(id);
        return ResponseEntity.ok(team);
    }
}
