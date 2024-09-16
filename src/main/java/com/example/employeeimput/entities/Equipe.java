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
@Table(name="equipe")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @ManyToOne
    private Projet projet;

    @OneToMany(mappedBy = "equipe")
    private List<Employee> employes= new ArrayList<>();

    @ManyToOne
    private Administrateur admin;



}
