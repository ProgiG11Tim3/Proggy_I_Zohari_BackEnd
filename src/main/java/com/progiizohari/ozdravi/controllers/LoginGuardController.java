package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.services.DoctorService;
import com.progiizohari.ozdravi.services.ParentService;
import com.progiizohari.ozdravi.services.PediatricianService;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

import java.awt.desktop.UserSessionEvent;

@RestController
public class LoginGuardController {

    @Autowired
    private LoginSessionHandler login_session_handler;
    @Autowired
    private ParentService parent_service;
    @Autowired
    private DoctorService doctor_service;
    @Autowired
    private PediatricianService pediatrician_service;

    @RequestMapping(value = "/loginguard", method = RequestMethod.POST)
    public ResponseEntity<String> login_guard() {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        String result = login_session_handler.loginGuard(sessionID);

        if (result == "OK") {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        String result = login_session_handler.logout(sessionID);

        if (result == "OK") {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }

    @GetMapping("/currentLoggedInUserDetails")
    public ResponseEntity<CurrentActiveUser> getCurrentLoggedInUserDetails() {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        LoginSession userSession = login_session_handler.getCurrectLoginSession(sessionID);

        if (userSession == null) {
            return ResponseEntity.badRequest().body(null);
        }

        CurrentActiveUser currentActiveUser = new CurrentActiveUser();
        currentActiveUser.setRole(userSession.getRole());

        if (userSession.getRole().equals("PARENT")) {
            for (Parent parent : parent_service.getAll()) {
                if (parent.getUserNameParent().equals(userSession.getUsername()) && parent.getPasswordParent().equals(userSession.getPassword())) {
                    currentActiveUser.setName(parent.getNameParent());
                    currentActiveUser.setSurname(parent.getLastNameParent());
                    break;
                }
            }
        } else if (userSession.getRole().equals("DOCTOR")) {
            for (Doctor doctor : doctor_service.getAll()) {
                if (doctor.getUserNameDoctor().equals(userSession.getUsername()) && doctor.getPasswordDoctor().equals(userSession.getPassword())) {
                    currentActiveUser.setName(doctor.getNameDoctor());
                    currentActiveUser.setSurname(doctor.getLastNameDoctor());
                    break;
                }
            }
        } else if (userSession.getRole().equals("PEDIATRICIAN")) {
            for (Pediatrician pediatrician : pediatrician_service.getAll()) {
                if (pediatrician.getUserNamePediatrician().equals(userSession.getUsername()) && pediatrician.getPasswordPediatrician().equals(userSession.getPassword())) {
                    currentActiveUser.setName(pediatrician.getNamePediatrician());
                    currentActiveUser.setSurname(pediatrician.getLastNamePediatrician());
                    break;
                }
            }
        } else {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(currentActiveUser);
    }
}
