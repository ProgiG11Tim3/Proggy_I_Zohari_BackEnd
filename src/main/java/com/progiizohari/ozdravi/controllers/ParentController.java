package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ParentController {

    @Autowired
    private ParentRepository repository;

    //primjer Parenta u repozitoriju za testiranje
    Parent testParent = new Parent(1, "oib123", "imeRoditelja",
            "prezimeRoditelja", LocalDate.of(2023, 11, 7),
            "userNameRoditelja", "passwordRoditelja", "brojMobitelaRoditelja",
            "emailRoditelja@gmail.com", 10000, "Zagreb", "emailPoslodavca@gmail.com",
            null, null);
 
    @PostMapping("/addParent")
    public String add(@RequestBody Parent parent) {
        //repository.save(parent);
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
