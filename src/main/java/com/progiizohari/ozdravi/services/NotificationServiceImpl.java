package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Notification;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.NotificationRepository;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Notification> getAllNotifications() {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        if(!loginSessionHandler.isUserLoggedIn(sessionID)){
            return null;
        }
        Parent parent = loginSessionHandler.getParent(sessionID);

        return repository.findAllByParent_OIB(parent.getOIB());
    }
}
