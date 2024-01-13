package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Child;
import com.progiizohari.ozdravi.domain.Pediatrician;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PediatricianService {

    public String add(Pediatrician pediatrician);
    public List<Pediatrician> getAll();
    public Optional<Pediatrician> getById(int Id);
    public boolean remove(Pediatrician pediatrician);
    public boolean remove(int id);
    public boolean edit(int id, Pediatrician newPediatricianData);
    //UC12
    public List<Child> getAllPatients();
    //UC13
    public Child getPatientByOIB(String OIB);
}