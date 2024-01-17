package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.services.*;
import com.progiizohari.ozdravi.services.ParentService;
import com.progiizohari.ozdravi.util.Argon2Crypting;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import jakarta.servlet.Registration;
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
    public ResponseEntity<String> register(@RequestBody RegistrationRequest parentJson) {
        parentJson.setPassword(argon2.HashPassword(parentJson.getPassword()));
        Parent parent = parentJson.toParent();

        String result = parent_service.add(parent);

        if (result == "Trying to add Parent that already exists!")
        {
            System.out.println("Parent already exists");
            return ResponseEntity.ok("Parent already exists!");
        }

        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        boolean already_logged_in = login_session_service.checkSession(parent.getUserNameParent(), parent.getPasswordParent(), "PARENT", sessionID);
        if (already_logged_in) {
            login_session_service.remove(login_session_service.getUserOfSession(sessionID));
        }
        login_session_service.add(new LoginSession(parent.getUserNameParent(), parent.getPasswordParent(), "PARENT", sessionID, true));

        System.out.println("registriran novi parent");
        return ResponseEntity.ok("OK");
    }
}
