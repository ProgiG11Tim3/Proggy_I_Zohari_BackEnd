package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Doctor;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.DoctorRepository;
import com.progiizohari.ozdravi.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService service;
    @PostMapping("/addDoctor")
    public String add(@RequestBody Doctor doctor) {
        return service.add(doctor);
    }
    @GetMapping("/getAllDoctors")
    public List<Doctor> getAll() {
        return service.getAll();
    }
    @GetMapping("/getDoctor/{Id}")
    public Optional<Doctor> getById(@PathVariable int Id) {
        return service.getById(Id);
    }

    //UC12
    @GetMapping("/doctor/getAllPatients")
    public ResponseEntity<List<Parent>> getAllPatients() {
        List<Parent> parents = service.getAllPatients();

        if(parents == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(parents);
    }

    //UC13
    @GetMapping("/doctor/getPatient/{OIB}")
    public ResponseEntity<Parent> getPatientByOIB(@PathVariable String OIB) {
        Parent parent = service.getPatientByOIB(OIB);

        if(parent == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(parent);
    }
}