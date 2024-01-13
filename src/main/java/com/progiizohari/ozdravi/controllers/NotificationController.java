package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Notification;
import com.progiizohari.ozdravi.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService service;

    //UC4
    @GetMapping("/getAllParentNotifications")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = service.getAllParentNotifications();

        if(notifications == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(notifications);
    }

}
