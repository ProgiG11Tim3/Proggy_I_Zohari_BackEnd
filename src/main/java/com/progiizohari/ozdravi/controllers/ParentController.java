package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Notification;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.ParentRepository;
import com.progiizohari.ozdravi.services.ParentService;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ParentController {

    @Autowired
    private ParentService service;
    @Autowired
    private LoginSessionHandler loginSessionHandler;

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

    @GetMapping("/getLoggedInParent")
    public ResponseEntity<Parent> getLoggedInParent() {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Parent parent = loginSessionHandler.getParent(sessionID);
        if (parent == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(parent);
    }

}