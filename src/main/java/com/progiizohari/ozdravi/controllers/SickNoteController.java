package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.SickNote;
import com.progiizohari.ozdravi.services.SickNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SickNoteController {

    @Autowired
    private SickNoteService service;

    @PostMapping("/addSickNote")
    public String addSickNote(@RequestBody SickNote sickNote) {
        return service.add(sickNote);
    }
}
