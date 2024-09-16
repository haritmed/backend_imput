package com.example.employeeimput.services;


import com.example.employeeimput.entities.Profile;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProfileService {
    Profile saveProfile(Profile profile); //"Create" pour créer un nouveau client s'il nexiste pas id
    Profile updateProfile(Long id, Profile profile);//"Update"
    void deleteProfileById(Long id);//"Delete by id"
    void deleteAllProfile();//"Delete All"
    Profile getProfileById(Long id); //"Read by id"
    List<Profile> getAllProfile();
    Page<Profile> getAllProfileByPage(int page, int size);
    Profile findByName(String name);
}
