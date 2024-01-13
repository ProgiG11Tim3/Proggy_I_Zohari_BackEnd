package com.progiizohari.ozdravi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @RequestMapping(value = "/odabirprofila", method = RequestMethod.GET)
    public ResponseEntity<String> odabirprofila() {
        return ResponseEntity.ok("OK");
    }
}
