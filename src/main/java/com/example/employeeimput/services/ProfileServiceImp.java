package com.example.employeeimput.services;


import com.example.employeeimput.dto.ProjetDto;
import com.example.employeeimput.entities.Profile;
import com.example.employeeimput.entities.Projet;
import com.example.employeeimput.exceptions.ResourceNotFoundException;
import com.example.employeeimput.mapper.ProjetMapper;
import com.example.employeeimput.repositories.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfileServiceImp implements ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile updateProfile(Long id, Profile profile) {
        Profile profile1 =profileRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Profile does not exist with given id"+id)
        );
        profile1.setName(profile.getName());
        profile1.setAge(profile.getAge());
        profile1.setFunction(profile.getFunction());
        profile1.setTeam(profile.getTeam());
        profile1.setProject(profile.getProject());
        Profile updatedProfile= profileRepository.save(profile1);
        return updatedProfile;
    }

    @Override
    public void deleteProfileById(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public void deleteAllProfile() {
        profileRepository.deleteAll();
    }

    @Override
    public Profile getProfileById(Long id) {
        return profileRepository.findById(id).get();
    }

    @Override
    public List<Profile> getAllProfile() {
        return profileRepository.findAll();
    }

    @Override
    public Page<Profile> getAllProfileByPage(int page, int size) {
        return profileRepository.findAll(PageRequest.of(page, size));
    }
    @Override
    public Profile findByName(String name) {
        return profileRepository.findByName(name);
    }
}
