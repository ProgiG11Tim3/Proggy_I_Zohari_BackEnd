package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.SickLeaveRecommendation;
import com.progiizohari.ozdravi.services.SickLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SickLeaveController {

    @Autowired
    private SickLeaveService sickLeaveService;

    @PostMapping("/addSickLeave")
    public String addSickLeave(@RequestBody SickLeaveRecommendation sickLeave) {
        return sickLeaveService.add(sickLeave);
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
}
