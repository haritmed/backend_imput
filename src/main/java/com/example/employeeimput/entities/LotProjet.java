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
public class LotProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private int heuresAllouees;

    @ManyToOne
    private Projet projet;

    @OneToMany(mappedBy = "lotProjet")
    private List<Imputation> imputations=new ArrayList<>();
    @ManyToOne
    private Administrateur admin;


}
