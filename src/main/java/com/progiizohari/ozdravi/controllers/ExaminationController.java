package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Examination;
import com.progiizohari.ozdravi.services.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExaminationController {

    @Autowired
    private ExaminationService service;

    @PostMapping("/addExamination")
    public String add(@RequestBody Examination examination) {
        return service.add(examination);
    }

    @GetMapping("/getAllExaminations")
    public List<Examination> getAllExaminations() {
        return service.getAllExaminations();
    }
}
