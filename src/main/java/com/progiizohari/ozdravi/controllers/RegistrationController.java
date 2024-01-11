package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.services.*;
import com.progiizohari.ozdravi.services.ParentService;
import com.progiizohari.ozdravi.util.Argon2Crypting;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;


@RestController
public class RegistrationController {
    int parent_ID = 0;

    @Autowired
    Argon2Crypting argon2;
    @Autowired
    private ParentService parent_service;
    @Autowired
    private DoctorService doctor_service;
    @Autowired
    private PediatricianService pediatrician_service;
    @Autowired
    private LoginSessionService login_session_service;

     @Autowired
    LoginSessionHandler sessionHandler;

    // hakuna matata
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody Parent parentJson) {
        parentJson.setPasswordParent(argon2.HashPassword(parentJson.getPasswordParent()));
        parent_service.add(parentJson);

        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        login_session_service.add(new LoginSession(parentJson.getUserNameParent(), parentJson.getPasswordParent(), "PARENT", sessionID, true));

        System.out.println("registriran novi parent");
        return ResponseEntity.ok("OK");
    }
}
