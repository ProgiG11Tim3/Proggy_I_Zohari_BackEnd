package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.HospitalLocation;
import com.progiizohari.ozdravi.services.HospitalLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HospitalLocationController {

    @Autowired
    private HospitalLocationService hospitalLocationService;


    @GetMapping("/getAllHospitalLocations")
    public ResponseEntity<List<HospitalLocation>> getAllExaminationLocations() {

        List<HospitalLocation> hospitalLocations = hospitalLocationService.getAllHospitalLocations();

        if (hospitalLocations == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(hospitalLocations);
    }
}
