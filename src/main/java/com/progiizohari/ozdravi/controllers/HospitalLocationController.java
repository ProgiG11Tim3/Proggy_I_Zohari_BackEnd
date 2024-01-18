package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.HospitalLocation;
import com.progiizohari.ozdravi.services.HospitalLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalLocationController {

    @Autowired
    private HospitalLocationService hospitalLocationService;

    public ResponseEntity<List<HospitalLocation>> getAllExaminationLocations(@PathVariable String text) {

        return null;
    }
}
