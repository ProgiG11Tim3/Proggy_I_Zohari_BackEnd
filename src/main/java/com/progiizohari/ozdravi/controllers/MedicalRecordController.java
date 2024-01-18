package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.MedicalRecord;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.services.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;

    @GetMapping("/getMedicalRecord/{id}")
    public MedicalRecord getByRecordId(@PathVariable String id) {
        return service.getByRecordId(Integer.parseInt(id));
    }
}
