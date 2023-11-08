package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.ParentRepository;
import com.progiizohari.ozdravi.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ParentController {

    @Autowired
    private ParentService service;
 
    @PostMapping("/addParent")
    public String add(@RequestBody Parent parent) {
        return service.add(parent);
    }

    @GetMapping("/getAllParents")
    public List<Parent> getAll() {
        return service.getAll();
    }

    @GetMapping("/getParent/{OIB}")
    public Parent getByOIB(@PathVariable String OIB) {
        return service.getByOIB(OIB);
    }

}
