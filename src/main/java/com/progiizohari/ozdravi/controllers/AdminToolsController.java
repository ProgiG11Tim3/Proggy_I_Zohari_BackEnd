package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.util.AdminTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminToolsController {

    @Autowired
    private AdminTools admin_tools;

    // UC 24
    @PostMapping("/admin/createPediatrician")
    public ResponseEntity<String> createPediatrician(@RequestBody CreatePediatrician createPediatrician) {
        Pediatrician pediatrician = new Pediatrician();
        pediatrician.setEmailPediatrician(createPediatrician.getEmailPediatrician());
        pediatrician.setNamePediatrician(createPediatrician.getNamePediatrician());
        pediatrician.setLastNamePediatrician(createPediatrician.getLastNamePediatrician());
        pediatrician.setUserNamePediatrician(createPediatrician.getUserNamePediatrician());
        pediatrician.setPasswordPediatrician(createPediatrician.getPasswordPediatrician());
        pediatrician.setPhoneNumberPediatrician(createPediatrician.getPhoneNumberPediatrician());
        pediatrician.setDateOfBirthPediatrician(createPediatrician.getDateOfBirthPediatrician());
        boolean success = admin_tools.createPediatrician(pediatrician);

        if (success) {
            return ResponseEntity.ok("Pedijatar uspješno kreiran!");
        } else {
            return ResponseEntity.badRequest().body("Pedijatar sa istim podatcima vec postoji!");
        }
    }

    // UC 24
    @PostMapping("/admin/createDoctr")
    public ResponseEntity<String> createDoctr(@RequestBody CreateDoctor createDoctor) {
        Doctor doctor = new Doctor();
        doctor.setEmailDoctor(createDoctor.getEmailDoctor());
        doctor.setNameDoctor(createDoctor.getNameDoctor());
        doctor.setLastNameDoctor(createDoctor.getLastNameDoctor());
        doctor.setUserNameDoctor(createDoctor.getUserNameDoctor());
        doctor.setPasswordDoctor(createDoctor.getPasswordDoctor());
        doctor.setPhoneNumberDoctor(createDoctor.getPhoneNumberDoctor());
        doctor.setDateOfBirthDoctor(createDoctor.getDateOfBirthDoctor());
        boolean success = admin_tools.createDoctor(doctor);

        if (success) {
            return ResponseEntity.ok("Doktor uspješno kreiran!");
        } else {
            return ResponseEntity.badRequest().body("Doktor sa istim podatcima vec postoji!");
        }
    }

    // UC 25
    @GetMapping("/admin/getAllParents")
    public ResponseEntity<String> getAllParents() {
        return ResponseEntity.ok(admin_tools.getAllParents());
    }

    // UC 25
    @GetMapping("/admin/getAllDoctors")
    public ResponseEntity<String> getAllDoctors() {
        return ResponseEntity.ok(admin_tools.getAllDoctors());
    }

    // UC 25
    @GetMapping("/admin/getAllPediatricians")
    public ResponseEntity<String> getAllPediatricians() {
        return ResponseEntity.ok(admin_tools.getAllPediatricians());
    }

    // UC 25
    @PostMapping("/admin/getAllPeople")
    public ResponseEntity<String> getAllPeople() {
        return ResponseEntity.ok(admin_tools.getAllParents() + admin_tools.getAllDoctors() + admin_tools.getAllPediatricians());
    }

    // UC 26

}
