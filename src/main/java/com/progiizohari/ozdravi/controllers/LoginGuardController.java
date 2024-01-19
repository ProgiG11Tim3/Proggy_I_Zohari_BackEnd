package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
public class LoginGuardController {

    @Autowired
    private LoginSessionHandler login_session_handler;

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

}
