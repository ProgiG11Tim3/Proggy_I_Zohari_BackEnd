package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Examination;
import com.progiizohari.ozdravi.domain.Notification;
import com.progiizohari.ozdravi.services.ExaminationService;
import com.progiizohari.ozdravi.services.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class ExaminationController {

    @Autowired
    private ExaminationService service;

    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping("/addExamination")
    public ResponseEntity<Examination> add(@RequestBody Examination examination) {

        //Bracun dodaj provjeru jel osoba koja dodaje novi pregled ulogiran i je li on LOM ili pedijatar pacijenta kojem dodaje pregled
        if (examination.getMedicalCertificate().equals("D")) {

            if (medicalRecordService.setCurrentDiagnosis(examination.getDiagnosis(), examination.getMedicalRecord().getRecordId())) {
                System.out.println("Promjenjena je currentDiganosis u Medical Recordu");
                examination.getMedicalRecord().setCurrentDiagnosis(examination.getDiagnosis());
            }

        }

        service.add(examination);

        return ResponseEntity.ok(examination);
    }

    @GetMapping("/getAllExaminations")
    public List<Examination> getAllExaminations() {
        return service.getAllExaminations();
    }

    //UC7
    @GetMapping(value = "/{text}/getAllSelectedExaminations")
    public ResponseEntity<List<Examination>> getAllSelectedPersonExaminations(@PathVariable String text) {

        if (text.equals("parentprofile")) {
            List<Examination> examinations = service.getOnlyParentExaminations();

            if(examinations == null) {
                return ResponseEntity.badRequest().body(null);
            }

            Collections.sort(examinations, Comparator.comparing(Examination::getDateOfExamination).reversed());

            return ResponseEntity.ok(examinations);

        } else if (text.matches("^childprofile\\d$")) {
            int index = Character.getNumericValue(text.charAt(text.length() - 1));

            List<Examination> examinations = service.getOnlyChildExaminations(index);

            if(examinations == null) {
                return ResponseEntity.badRequest().body(null);
            }

            Collections.sort(examinations, Comparator.comparing(Examination::getDateOfExamination).reversed());

            return ResponseEntity.ok(examinations);
        }

        return ResponseEntity.badRequest().body(null);
    }
}
