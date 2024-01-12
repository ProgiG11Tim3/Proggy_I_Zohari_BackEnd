package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.services.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;
}
