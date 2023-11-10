package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Doctor;
import com.progiizohari.ozdravi.repositories.DoctorRepository;
import com.progiizohari.ozdravi.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
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
}