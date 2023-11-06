package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParentController {

    @Autowired
    private ParentRepository repository;
    @PostMapping("/addParent")
    public String add(@RequestBody Parent parent) {
        repository.save(parent);
        return "Parent " + parent.getNameParent() + " " + parent.getLastNameParent() + " successfully added!";
    }
    @GetMapping("/getAllParents")
    public List<Parent> getAll() {
        return repository.findAll();
    }
    @GetMapping("/getParent/{OIB}")
    public Parent getByOIB(@PathVariable String OIB) {
        return repository.findByOIB(OIB);
    }


}
