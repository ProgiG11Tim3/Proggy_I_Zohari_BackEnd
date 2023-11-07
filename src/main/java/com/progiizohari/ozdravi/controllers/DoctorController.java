package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Doctor;
import com.progiizohari.ozdravi.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    @Autowired
    private DoctorRepository repository;
    @PostMapping("/addDoctor")
    public String add(@RequestBody Doctor doctor) {
        repository.save(doctor);
        return "Doctor " + doctor.getNameDoctor() + " " + doctor.getLastNameDoctor() + " successfully added!";
    }
    @GetMapping("/getAllDoctors")
    public List<Doctor> getAll() {
        return repository.findAll();
    }
    @GetMapping("/getDoctor/{Id}")
    public Optional<Doctor> getById(@PathVariable int Id) {
        return repository.findById(Id);
    }
}
