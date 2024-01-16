package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.services.DoctorService;
import com.progiizohari.ozdravi.services.ParentService;
import com.progiizohari.ozdravi.services.PediatricianService;
import com.progiizohari.ozdravi.util.AdminTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminToolsController {

    @Autowired
    private AdminTools admin_tools;
    @Autowired
    private ParentService parent_service;
    @Autowired
    private DoctorService doctor_service;
    @Autowired
    private PediatricianService pediatrician_service;

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
    public ResponseEntity<List<StringWithLink>> getAllParents() {
        List<StringWithLink> return_list = new ArrayList<>();

        for (Parent parent : parent_service.getAll()) {
            StringWithLink string_with_link = new StringWithLink();
            string_with_link.setString(parent.toJson());
            string_with_link.setLink("/admin/getParent/" + parent.getParentId());
            return_list.add(string_with_link);
        }

        return ResponseEntity.ok(return_list);
    }

    // UC 25
    @GetMapping("/admin/getAllDoctors")
    public ResponseEntity<List<StringWithLink>> getAllDoctors() {
        List<StringWithLink> return_list = new ArrayList<>();

        for (Doctor doctor : doctor_service.getAll()) {
            StringWithLink string_with_link = new StringWithLink();
            string_with_link.setString(doctor.toJson());
            string_with_link.setLink("/admin/getDoctor/" + doctor.getDoctorId());
            return_list.add(string_with_link);
        }

        return ResponseEntity.ok(return_list);
    }

    // UC 25
    @GetMapping("/admin/getAllPediatricians")
    public ResponseEntity<List<StringWithLink>> getAllPediatricians() {
        List<StringWithLink> return_list = new ArrayList<>();

        for (Pediatrician pediatrician : pediatrician_service.getAll()) {
            StringWithLink string_with_link = new StringWithLink();
            string_with_link.setString(pediatrician.toJson());
            string_with_link.setLink("/admin/getPediatrician/" + pediatrician.getPediatricianId());
            return_list.add(string_with_link);
        }

        return ResponseEntity.ok(return_list);
    }

    // UC 25
    @PostMapping("/admin/getAllPeople")
    public ResponseEntity<List<StringWithLink>> getAllPeople() {
        List<StringWithLink> return_list = new ArrayList<>();

        for (Parent parent : parent_service.getAll()) {
            StringWithLink string_with_link = new StringWithLink();
            string_with_link.setString(parent.toJson());
            string_with_link.setLink("/admin/getParent/" + parent.getParentId());
            return_list.add(string_with_link);
        }

        for (Doctor doctor : doctor_service.getAll()) {
            StringWithLink string_with_link = new StringWithLink();
            string_with_link.setString(doctor.toJson());
            string_with_link.setLink("/admin/getDoctor/" + doctor.getDoctorId());
            return_list.add(string_with_link);
        }

        for (Pediatrician pediatrician : pediatrician_service.getAll()) {
            StringWithLink string_with_link = new StringWithLink();
            string_with_link.setString(pediatrician.toJson());
            string_with_link.setLink("/admin/getPediatrician/" + pediatrician.getPediatricianId());
            return_list.add(string_with_link);
        }

        return ResponseEntity.ok(return_list);
    }

    // UC 26
    
}
