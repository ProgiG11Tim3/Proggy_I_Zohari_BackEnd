package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Child;
import com.progiizohari.ozdravi.domain.Notification;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.NotificationRepository;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private NotificationRepository repository;

    @Autowired
    private LoginSessionHandler loginSessionHandler;

    @Override
    public List<Notification> getAllParentNotifications() {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Parent parent = loginSessionHandler.getParent(sessionID);

        if(parent == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        return repository.findAllByParent_OIB(parent.getOIB());
    }

    @Override
    public List<Notification> getOnlyParentNotifications() {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Parent parent = loginSessionHandler.getParent(sessionID);

        if(parent == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        return repository.findNotificationsByChildIsNullAndParent_OIB(parent.getOIB());
    }

    @Override
    public List<Notification> getOnlyChildNotificaitons(int index) {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Parent parent = loginSessionHandler.getParent(sessionID);

        if(parent == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        if (index >= parent.getChildren().size()) {
            return null;
        }

        Child child = parent.getChildren().get(index);

        return repository.findNotificationsByChild_OIB(child.getOIB());
    }


}
