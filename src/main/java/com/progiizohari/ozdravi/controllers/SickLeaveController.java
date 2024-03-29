package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.SickLeaveRecommendation;
import com.progiizohari.ozdravi.services.SickLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class SickLeaveController {

    @Autowired
    private SickLeaveService sickLeaveService;

    @PostMapping("/addSickLeave")
    public ResponseEntity<SickLeaveRecommendation> addSickLeave(@RequestBody SickLeaveRecommendation sickLeave) {
        System.out.println(sickLeave);
        sickLeave.setSickLeaveStartDate(new Date(System.currentTimeMillis()));
        sickLeave.setApproved(false);
        sickLeaveService.add(sickLeave);
        return ResponseEntity.ok(sickLeave);
    }

    @GetMapping("/getAllSickLeaves")
    public List<SickLeaveRecommendation> getAll() {

        return sickLeaveService.getAll();
    }

    //UC23 za prikazat sve nepotvrdena bolovanja kako bi se mogli potvrdit
    @GetMapping("/getAllUnapprovedSickLeaves")
    public List<SickLeaveRecommendation> getUnapproved() {
        return sickLeaveService.getUnapproved();
    }

    @PostMapping("/approveSickLeave/{id}")
    public String approveSickLeave(@PathVariable int id) {
        return sickLeaveService.approve(id);
    }

    @GetMapping("/getSickLeave/{id}")
    public ResponseEntity<SickLeaveRecommendation> getById(@PathVariable int id) {
        for (SickLeaveRecommendation sickLeave : sickLeaveService.getAll()) {
            if (sickLeave.getRecommendationId() == id) {
                return ResponseEntity.ok(sickLeave);
            }
        }
        return ResponseEntity.badRequest().body(null);
    }
}
