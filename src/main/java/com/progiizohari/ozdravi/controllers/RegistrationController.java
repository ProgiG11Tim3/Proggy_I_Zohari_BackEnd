package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.services.*;
import com.progiizohari.ozdravi.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class RegistrationController {
    int parent_ID = 0;

    @Autowired
    private ParentService parent_service;
    @Autowired
    private DoctorService doctor_service;
    @Autowired
    private PediatricianService pediatrician_service;

    // currently only works for parent registrations cuz not consistency in data received and too much work and data dumping to make it work efficiently for all 3
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody Parent parentJson) {
        parent_service.add(parentJson);
        System.out.println("registriran novi parent");
        return ResponseEntity.ok("OK");
    }
}
