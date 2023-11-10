package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Pediatrician;
import com.progiizohari.ozdravi.repositories.PediatricianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PediatricianServiceImpl implements PediatricianService {

    @Autowired
    private PediatricianRepository repository;
    @Override
    public String add(Pediatrician pediatrician) {
        repository.save(pediatrician);
        return "Pediatrician " + pediatrician.getNamePediatrician() + " " + pediatrician.getLastNamePediatrician() + " successfully added!";
    }

    @Override
    public List<Pediatrician> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Pediatrician> getById(int Id) {
        return repository.findById(Id);
    }
}