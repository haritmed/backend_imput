package com.example.employeeimput.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="imputations")
public class Imputation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Integer hoursWorked;
    private String content;

    @ManyToOne
    private LotProjet lotProjet;
    @ManyToOne
    private Employee employee;
}

