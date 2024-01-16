package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.SickLeaveRecommendation;
import com.progiizohari.ozdravi.services.SickLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SickLeaveController {

    @Autowired
    private SickLeaveService sickLeaveService;

    @PostMapping("/addSickLeave")
    public String addSickLeave(@RequestBody SickLeaveRecommendation sickLeave) {
        return sickLeaveService.add(sickLeave);
    }
}
