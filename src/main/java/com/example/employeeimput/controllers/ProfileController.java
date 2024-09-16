package com.example.employeeimput.controllers;


import com.example.employeeimput.dto.ProjetDto;
import com.example.employeeimput.entities.Imputation;
import com.example.employeeimput.entities.Profile;
import com.example.employeeimput.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.employeeimput.repositories.ProfileRepository;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@AllArgsConstructor
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private ProfileService profileService;
private ProfileRepository profileRepository;
    //build add employee rest api
    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile projetDto){
        Profile savedProjet=profileService.saveProfile(projetDto);
        return new ResponseEntity<>(savedProjet, HttpStatus.CREATED);
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Profile> getProfileByName(@RequestParam String name) {
        Profile profile = profileService.findByName(name);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //build get employee rest api
    @GetMapping("{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") Long id){
        Profile profile=profileService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }
    // build get all employees rest api
    @GetMapping
    public ResponseEntity<List<Profile>>getAllProfiles(){
        List<Profile> projets =profileService.getAllProfile();
        return ResponseEntity.ok(projets);
    }
    // build update employee rest api
    @PutMapping("{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable("id") Long id,
                                                   @RequestBody Profile projet2){
        Profile projetDto =profileService.updateProfile(id, projet2);
        return ResponseEntity.ok(projetDto);
    }

    //build delete employee rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable("id") Long id){
        profileService.deleteProfileById(id);
        return ResponseEntity.ok("Project deleted successfully!!");
    }
    @DeleteMapping
    public ResponseEntity<String> deleteAllProfile(){
        profileService.deleteAllProfile();
        return ResponseEntity.ok("profiles deleted successfully!!");
    }


}


