package com.example.employeeimput.controllers;
import com.example.employeeimput.dto.ProjetDto;
import com.example.employeeimput.entities.Event;
import com.example.employeeimput.entities.Projet;
import com.example.employeeimput.services.ProjetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@AllArgsConstructor
@RestController
@RequestMapping("/api/projet")
public class ProjetController {

    private ProjetService projetService;

    //build add employee rest api
    @PostMapping
    public Projet createProject(@RequestBody Projet event) {
        return projetService.saveProjet(event);
    }

    //build get employee rest api
    @GetMapping("{id}")
    public ResponseEntity<ProjetDto> getProjectById(@PathVariable("id") Long id){
        ProjetDto ProjetDto=projetService.getProjetById(id);
        return ResponseEntity.ok(ProjetDto);
    }
    // build get all employees rest api
    @GetMapping
    public ResponseEntity<List<ProjetDto>>getAllProjects(){
        List<ProjetDto> projets =projetService.getAllProjet();
        return ResponseEntity.ok(projets);
    }
    // build update employee rest api
    @PutMapping("{id}")
    public ResponseEntity<ProjetDto> updateProject(@PathVariable("id") Long id,
                                                      @RequestBody ProjetDto projet2){
        ProjetDto projetDto =projetService.updateProjet(id, projet2);
        return ResponseEntity.ok(projetDto);
    }

    //build delete employee rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Long id){
        projetService.deleteProjetById(id);
        return ResponseEntity.ok("Project deleted successfully!!");
    }
}

