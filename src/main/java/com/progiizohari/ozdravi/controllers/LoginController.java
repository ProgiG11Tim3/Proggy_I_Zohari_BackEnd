package com.progiizohari.ozdravi.controllers;

import java.util.List;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.repositories.DoctorRepository;
import com.progiizohari.ozdravi.repositories.LoginSesssionRepository;
import com.progiizohari.ozdravi.repositories.PediatricianRepository;
import com.progiizohari.ozdravi.services.LoginSessionService;
import com.progiizohari.ozdravi.util.Argon2Crypting;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.progiizohari.ozdravi.repositories.ParentRepository;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
public class LoginController {
    @Autowired
    Argon2Crypting argon2;
    @Autowired
    private ParentRepository parent_repo;
    @Autowired
    private DoctorRepository doctor_repo;
    @Autowired
    private PediatricianRepository pediatrician_repo;
    @Autowired
    private LoginSessionService login_session_service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody LoginRequest loginJson) {
        List<Parent> parents = parent_repo.findAll();
        for (Parent parent : parents) {
            if (parent.getUserNameParent().equals(loginJson.getUsername()) && argon2.VerifyPassword(parent.getPasswordParent(), loginJson.getPassword())) {

                String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
                boolean already_logged_in = login_session_service.checkSession(parent.getUserNameParent(), parent.getPasswordParent(), "PARENT", sessionID);
                if (!already_logged_in) {
                    login_session_service.remove(login_session_service.getUserOfSession(sessionID));
                }
                login_session_service.add(new LoginSession(parent.getUserNameParent(), parent.getPasswordParent(), "PARENT", sessionID, true));

                System.out.println("Parent logged in");
                System.out.println("Login session registered " + sessionID);
                return ResponseEntity.ok("PARENT");
            }
        }

        List<Doctor> doctors = doctor_repo.findAll();
        for (Doctor doctor : doctors) {
            if (doctor.getUserNameDoctor().equals(loginJson.getUsername()) && argon2.VerifyPassword(doctor.getPasswordDoctor(), loginJson.getPassword())) {

                String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
                boolean already_logged_in = login_session_service.checkSession(doctor.getUserNameDoctor(), doctor.getPasswordDoctor(), "DOCTOR", sessionID);
                if (!already_logged_in) {
                    login_session_service.remove(login_session_service.getUserOfSession(sessionID));
                }
                login_session_service.add(new LoginSession(doctor.getUserNameDoctor(), doctor.getPasswordDoctor(), "DOCTOR", sessionID, true));

                System.out.println("Doctor logged in");
                return ResponseEntity.ok("DOCTOR");
            }
        }

        List<Pediatrician> pediatricians = pediatrician_repo.findAll();
        for (Pediatrician pediatrician : pediatricians) {
            if (pediatrician.getUserNamePediatrician().equals(loginJson.getUsername()) && argon2.VerifyPassword(pediatrician.getPasswordPediatrician(), loginJson.getPassword())) {

                String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
                boolean already_logged_in = login_session_service.checkSession(pediatrician.getUserNamePediatrician(), pediatrician.getPasswordPediatrician(), "PEDIATRICIAN", sessionID);
                if (!already_logged_in) {
                    login_session_service.remove(login_session_service.getUserOfSession(sessionID));
                }
                login_session_service.add(new LoginSession(pediatrician.getUserNamePediatrician(), pediatrician.getPasswordPediatrician(), "PEDIATRICIAN", sessionID, true));

                System.out.println("Pediatrician logged in");
                return ResponseEntity.ok("PEDIATRICIAN");
            }
        }

        System.out.println("invalid credentials");
        return ResponseEntity.badRequest().body("NOT FOUND");
    }
}
