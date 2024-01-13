package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Child;
import com.progiizohari.ozdravi.domain.Doctor;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.domain.Pediatrician;
import com.progiizohari.ozdravi.repositories.PediatricianRepository;
import com.progiizohari.ozdravi.services.PediatricianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PediatricianController {

    @Autowired
    private PediatricianService service;

    @PostMapping("/addPediatrician")
    public String add(@RequestBody Pediatrician pediatrician) {
        return service.add(pediatrician);
    }
    @GetMapping("/getAllPediatricians")
    public List<Pediatrician> getAll() {
        return service.getAll();
    }
    @GetMapping("/getPediatrician/{Id}")
    public Optional<Pediatrician> getById(@PathVariable int Id) {
        return service.getById(Id);
    }

    //UC12
    @GetMapping("/pediatrician/getAllPatients")
    public ResponseEntity<List<Child>> getAllPatients() {
        List<Child> children = service.getAllPatients();

        if(children == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(children);
    }

    //UC13
    @GetMapping("/pediatrician/getPatient/{OIB}")
    public ResponseEntity<Child> getPatientByOIB(@PathVariable String OIB) {
        Child child = service.getPatientByOIB(OIB);

        if(child == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(child);
    }
}