package com.progiizohari.ozdravi.controllers;

import java.util.List;

import com.progiizohari.ozdravi.domain.Doctor;
import com.progiizohari.ozdravi.domain.Pediatrician;
import com.progiizohari.ozdravi.repositories.DoctorRepository;
import com.progiizohari.ozdravi.repositories.PediatricianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.progiizohari.ozdravi.domain.LoginRequest;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.ParentRepository;

@RestController
public class LoginController {
    @Autowired
    private ParentRepository parent_repo;
    @Autowired
    private DoctorRepository doctor_repo;
    @Autowired
    private PediatricianRepository pediatrician_repo;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody LoginRequest loginJson) {

        List<Parent> parents = parent_repo.findAll();
        for (Parent parent : parents) {
            if (parent.getUserNameParent().equals(loginJson.getUsername()) && parent.getPasswordParent().equals(loginJson.getPassword())) {
                System.out.println("loggiran parent");
                return ResponseEntity.ok("PARENT");
            }
        }

        List<Doctor> doctors = doctor_repo.findAll();
        for (Doctor doctor : doctors) {
            if (doctor.getUserNameDoctor().equals(loginJson.getUsername()) && doctor.getPasswordDoctor().equals(loginJson.getPassword())) {
                System.out.println("loggiran doktor");
                return ResponseEntity.ok("DOCTOR");
            }
        }

        List<Pediatrician> pediatricians = pediatrician_repo.findAll();
        for (Pediatrician pediatrician : pediatricians) {
            if (pediatrician.getUserNamePediatrician().equals(loginJson.getUsername()) && pediatrician.getPasswordPediatrician().equals(loginJson.getPassword())) {
                System.out.println("loggiran pediatar");
                return ResponseEntity.ok("PEDIATRICIAN");
            }
        }

        System.out.println("losi cridentials");
        return ResponseEntity.badRequest().body("NOT FOUND");
    }
}
