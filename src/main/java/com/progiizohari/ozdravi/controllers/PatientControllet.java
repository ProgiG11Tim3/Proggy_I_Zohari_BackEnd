package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.services.ParentService;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
public class PatientControllet {

    @Autowired
    private ParentService parent_service;
    @Autowired
    private LoginSessionHandler login_session_handler;

    @RequestMapping(value = "/unospacijentabyoib", method = RequestMethod.POST)
    public ResponseEntity<String> UnosPacijentaByOIB(@RequestBody String OIB) {
        // check if doctor is logged in
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Doctor doctor = login_session_handler.getDoctor(sessionID);
        if (doctor == null) {
            return ResponseEntity.badRequest().body("Doctor not logged in!");
        }

        Parent patient = parent_service.getByOIB(OIB);
        if (patient == null) {
            return ResponseEntity.badRequest().body("Patient not found by OIB: " + OIB + "!");
        }
        doctor.addParent(patient);
        return ResponseEntity.ok("OK");
    }

    @RequestMapping(value = "/unospacijentchild", method = RequestMethod.POST)
    public ResponseEntity<String> UnosPacijentaChild(@RequestBody ChildRegistrationEntry childRegistrationEntryJson) {
        // check if doctor is logged in
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Pediatrician pediatrician = login_session_handler.getPediatrician(sessionID);
        if (pediatrician == null) {
            return ResponseEntity.badRequest().body("Pediatrician not logged in!");
        }

        Parent patient = parent_service.getByOIB(childRegistrationEntryJson.getParentOIB());
        if (patient == null) {
            return ResponseEntity.badRequest().body("Patient of child not found by OIB: " + childRegistrationEntryJson.getParentOIB() + "!");
        }

        Child child = new Child();
        child.setFromChildRegistrationEntry(childRegistrationEntryJson);
        child.setParent(patient);
        child.setPediatrician(pediatrician);

        return ResponseEntity.ok("OK");
    }
}
