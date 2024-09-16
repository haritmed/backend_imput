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
@Table(name="projet")
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double budgetTotal;
    private Integer heuresAllouees;

    @ManyToOne
    private Administrateur admin;


    @OneToMany(mappedBy = "projet")
    private List<Equipe> equipes=new ArrayList<>();

    @OneToMany(mappedBy = "projet")
    private List<LotProjet> lotprojets=new ArrayList<>();



    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees = new ArrayList<>();

    public Projet(Long id, String nom, double budgetTotal, Integer heuresAllouees) {
    }
}