package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.SickNote;
import com.progiizohari.ozdravi.services.SickNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SickNoteController {

    @Autowired
    private SickNoteService service;

    @PostMapping("/addSickNote")
    public String addSickNote(@RequestBody SickNote sickNote) {
        return service.add(sickNote);
    }

    //UC8
    @GetMapping(value = "/{text}/getAllSickNotes")
    public ResponseEntity<List<SickNote>> getAllSickNotes(@PathVariable String text) {

        if (text.matches("^childprofile\\d$")) {

            int index = Character.getNumericValue(text.charAt(text.length() - 1));

            List<SickNote> sickNotes = service.getAllChildSickNotes(index);

            if(sickNotes == null) {
                return ResponseEntity.badRequest().body(null);
            }

            return ResponseEntity.ok(sickNotes);

        }

        return ResponseEntity.badRequest().body(null);
    }
}
