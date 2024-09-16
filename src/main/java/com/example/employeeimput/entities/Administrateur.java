package com.example.employeeimput.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="admin")
public class Administrateur {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "admin")
    private List<Projet> projets = new ArrayList<>();
    @OneToMany(mappedBy = "admin")
    private List<Equipe> equipes=new ArrayList<>();
    @OneToMany(mappedBy = "admin")
    private List<Employee> employees=new ArrayList<>();
    @OneToMany(mappedBy = "admin")
    private List<LotProjet> lotProjets=new ArrayList<>();
}
