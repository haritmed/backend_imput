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
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int hourWorked;



    @OneToMany(mappedBy = "employee")
    private List<Imputation> imputations=new ArrayList<>();

    @ManyToOne
    private Administrateur admin;

    @ManyToOne
    private Equipe equipe;

    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employees_id"),
            inverseJoinColumns = @JoinColumn(name = "projet_id")
    )
    private List<Projet> projects = new ArrayList<>();



    public Employee(Long id, String firstName, String lastName, String email, int hourWorked) {
    }
}
