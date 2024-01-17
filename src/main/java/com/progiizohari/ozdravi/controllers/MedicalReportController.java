package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.MedicalRecord;
import com.progiizohari.ozdravi.domain.MedicalReport;
import com.progiizohari.ozdravi.services.MedicalRecordService;
import com.progiizohari.ozdravi.services.MedicalReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalReportController {
    @Autowired
    private MedicalReportService service;

    @GetMapping("/getMedicalReport/{id}")
    public MedicalReport getByReportId(@PathVariable String id) {
        return service.getByReportId(id);
    }
}
