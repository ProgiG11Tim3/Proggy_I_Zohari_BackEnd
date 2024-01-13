package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Notification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotificationService {
    //UC4
    public List<Notification> getAllParentNotifications();
}
