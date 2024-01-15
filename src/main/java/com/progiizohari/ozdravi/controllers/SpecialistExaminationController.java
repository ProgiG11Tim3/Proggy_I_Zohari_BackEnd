package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.SpecialistExamination;
import com.progiizohari.ozdravi.services.SpecialistExaminationService;
import com.progiizohari.ozdravi.services.SpecialistExaminationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class SpecialistExaminationController {

    @Autowired
    private SpecialistExaminationService service;

    //UC10
    @GetMapping(value = "/{text}/getAllSelectedSpecialistExaminations")
    public ResponseEntity<List<SpecialistExamination>> getAllSelectedPersonSpecialistExamination(@PathVariable String text) {

        if (text.equals("parentprofile")) {
            List<SpecialistExamination> specialistExaminations = service.getParentSpecialistExaminations();

            if (specialistExaminations == null) {
                return ResponseEntity.badRequest().body(null);
            }

            return ResponseEntity.ok(specialistExaminations);

        } else if (text.matches("^childprofile\\d$")) {
            int index = Character.getNumericValue(text.charAt(text.length() - 1));

            List<SpecialistExamination> specialistExaminations = service.getChildSpecialistExaminations(index);

            if (specialistExaminations == null) {
                return ResponseEntity.badRequest().body(null);
            }

            return ResponseEntity.ok(specialistExaminations);
        }

        return ResponseEntity.badRequest().body(null);
    }
}
