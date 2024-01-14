package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Child;
import com.progiizohari.ozdravi.domain.Notification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotificationService {
    //UC4
    public List<Notification> getAllParentNotifications();

    public List<Notification> getOnlyParentNotifications();

    public List<Notification> getOnlyChildNotificaitons(int index);
}
