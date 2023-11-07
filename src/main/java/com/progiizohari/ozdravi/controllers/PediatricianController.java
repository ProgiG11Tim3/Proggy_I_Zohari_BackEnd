package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Doctor;
import com.progiizohari.ozdravi.domain.Pediatrician;
import com.progiizohari.ozdravi.repositories.PediatricianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PediatricianController {

    @Autowired
    private PediatricianRepository repository;

    @PostMapping("/addPediatrician")
    public String add(@RequestBody Pediatrician pediatrician) {
        repository.save(pediatrician);
        return "Pediatrician " + pediatrician.getNamePediatrician() + " " + pediatrician.getLastNamePediatrician() + " successfully added!";
    }
    @GetMapping("/getAllPediatricians")
    public List<Pediatrician> getAll() {
        return repository.findAll();
    }
    @GetMapping("/getPediatrician/{Id}")
    public Optional<Pediatrician> getById(@PathVariable int Id) {
        return repository.findById(Id);
    }
}
