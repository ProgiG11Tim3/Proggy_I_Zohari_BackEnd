package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Notification;
import com.progiizohari.ozdravi.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService service;

    @PostMapping("/addNotification")
    public ResponseEntity<Notification> addNotification(@RequestBody Notification notification) {
        service.add(notification);
        return ResponseEntity.ok(notification);
    }

    //UC4
    @GetMapping("/getAllParentNotifications")
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = service.getAllParentNotifications();

        if(notifications == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(notifications);
    }

    //UC6
    @GetMapping(value = "/{text}/getAllNotifications")
    public ResponseEntity<List<Notification>> getAllSelectedPersonNotifications(@PathVariable String text) {
        
        if (text.equals("parentprofile")) {
            List<Notification> notifications = service.getOnlyParentNotifications();
            
            if(notifications == null) {
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.ok(notifications);
            
        } else if (text.matches("^childprofile\\d$")) {
            int index = Character.getNumericValue(text.charAt(text.length() - 1));

            List<Notification> notifications = service.getOnlyChildNotificaitons(index);

            if(notifications == null) {
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.ok(notifications);
        }

        return ResponseEntity.badRequest().body(null);
    }

}
