package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.repositories.PediatricianRepository;
import com.progiizohari.ozdravi.services.LoginSessionService;
import com.progiizohari.ozdravi.services.PediatricianService;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;
import java.util.Optional;

@RestController
public class PediatricianController {

    @Autowired
    private PediatricianService service;
    @Autowired
    private LoginSessionHandler loginSessionHandler;

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

    //UC14
    @GetMapping("/pediatrician/getPatientRecord/{OIB}")
    public ResponseEntity<MedicalRecord> getPatientRecord(@PathVariable String OIB){
        MedicalRecord medicalRecord = service.getPatientRecord(OIB);

        if(medicalRecord == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(medicalRecord);
    }

    //UC20
    @GetMapping("/pediatrician/getPatientReports/{OIB}")
    public ResponseEntity<List<MedicalReport>> getPatientReports(@PathVariable String OIB){
        List<MedicalReport> medicalReports = service.getPatientReports(OIB);

        if(medicalReports == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(medicalReports);
    }

    @GetMapping("/getLoggedInPediatrician")
    public ResponseEntity<Pediatrician> getLoggedInPediatrician() {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Pediatrician pediatrician = loginSessionHandler.getPediatrician(sessionID);
        if (pediatrician == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(pediatrician);
    }
}