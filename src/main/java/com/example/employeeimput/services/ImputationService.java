package com.example.employeeimput.services;

import com.example.employeeimput.entities.Employee;
import com.example.employeeimput.entities.Imputation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ImputationService {
    Imputation saveImputation(Imputation imputation); //"Create" pour créer un nouveau client s'il nexiste pas id
    Imputation updateImputation(Imputation imputation);//"Update"
    void deleteImputationById(Long id);//"Delete by id"
    void deleteAllImputation();//"Delete All"
    Imputation getImputationById(Long id); //"Read by id"
    List<Imputation> getAllImputation();
    Page<Imputation> getAllImputationByPage(int page, int size);
}
