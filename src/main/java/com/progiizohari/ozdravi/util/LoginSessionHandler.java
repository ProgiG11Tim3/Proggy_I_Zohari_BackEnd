package com.progiizohari.ozdravi.util;

import com.progiizohari.ozdravi.domain.Doctor;
import com.progiizohari.ozdravi.domain.LoginSession;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.domain.Pediatrician;
import com.progiizohari.ozdravi.services.DoctorService;
import com.progiizohari.ozdravi.services.LoginSessionService;
import com.progiizohari.ozdravi.services.ParentService;
import com.progiizohari.ozdravi.services.PediatricianService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import javax.print.Doc;
import java.util.List;

@Component
public class LoginSessionHandler {

    @Autowired
    private ParentService parent_service;
    @Autowired
    private DoctorService doctor_service;
    @Autowired
    private PediatricianService pediatrician_service;
    @Autowired
    private LoginSessionService login_session_service;

    // TODO: if we decide to only have singular login per browser client, contact Dino to refactor this and login session service
    public String loginGuard(String sessionID) {
        if (login_session_service.getAllUsersOfSession(sessionID).size() > 0) {
            System.out.println("LoginSessionHandler: loginGuild: user already logged in, proceeding without redirect.");
            return "OK";
        } else {
            System.out.println("LoginSessionHandler: loginGuild: user not logged in, redirecting to /login.");
            return "redirect:/login";
        }
    }

    // TODO: if we decide to only have singular login per browser client, contact Dino to refactor this and login session service
    public boolean isUserLoggedIn(String sessionID) {
        if (login_session_service.getAllUsersOfSession(sessionID).size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    // TODO: returns a list instead of just 1st OIB if there are multiple users logged in, if we decide to only have singular login per browser client, contact Dino to refactor this and login session service
    public String getUserOIB(String sessionID) {
        List<LoginSession> userSessions = login_session_service.getAllUsersOfSession(sessionID);
        if (userSessions.size() == 0) {
            return null;
        }
        LoginSession userSession = userSessions.get(0);
        String returnOIB = null;

        if (userSession.getRole().equals("PARENT")) {

            for (Parent parent : parent_service.getAll()) {
                if (parent.getUserNameParent().equals(userSession.getUsername()) && parent.getPasswordParent().equals(userSession.getPassword())) {
                    returnOIB = parent.getOIB();
                }
            }

        } /* else if (userSession.getRole().equals("DOCTOR")) {

            for (Doctor doctor : doctor_service.getAll()) {
                if (doctor.getUserNameDoctor().equals(userSession.getUsername()) && doctor.getPasswordDoctor().equals(userSession.getPassword())) {
                    returnOIB = doctor.getOIB();
                }
            }

        } else if (userSession.getRole().equals("PEDIATRICIAN")) {

            for (Pediatrician pediatrician : pediatrician_service.getAll()) {
                if (pediatrician.getUserNamePediatrician().equals(userSession.getUsername()) && pediatrician.getPasswordPediatrician().equals(userSession.getPassword())) {
                    returnOIB = pediatrician.getOIB();
                }
            }

        } */

        return returnOIB;
    }

    public Parent getParent(String sessionID)
    {
        List<LoginSession> userSessions = login_session_service.getAllUsersOfSession(sessionID);
        if (userSessions.size() == 0) {
            return null;
        }
        LoginSession userSession = userSessions.get(0);
        Parent returnParent = null;

        if (userSession.getRole().equals("PARENT")) {
            for (Parent parent : parent_service.getAll()) {
                if (parent.getUserNameParent().equals(userSession.getUsername()) && parent.getPasswordParent().equals(userSession.getPassword())) {
                    returnParent = parent;
                }
            }
        }
        return returnParent;
    }

    public Doctor getDoctor(String sessionID)
    {
        List<LoginSession> userSessions = login_session_service.getAllUsersOfSession(sessionID);
        if (userSessions.size() == 0) {
            return null;
        }
        LoginSession userSession = userSessions.get(0);
        Doctor returnDoctor = null;

        if (userSession.getRole().equals("DOCTOR")) {
            for (Doctor doctor : doctor_service.getAll()) {
                if (doctor.getUserNameDoctor().equals(userSession.getUsername()) && doctor.getPasswordDoctor().equals(userSession.getPassword())) {
                    returnDoctor = doctor;
                }
            }
        }
        return returnDoctor;
    }

    public Pediatrician getPediatrician(String sessionID)
    {
        List<LoginSession> userSessions = login_session_service.getAllUsersOfSession(sessionID);
        if (userSessions.size() == 0) {
            return null;
        }
        LoginSession userSession = userSessions.get(0);
        Pediatrician returnPediatrician = null;

        if (userSession.getRole().equals("PEDIATRICIAN")) {
            for (Pediatrician pediatrician : pediatrician_service.getAll()) {
                if (pediatrician.getUserNamePediatrician().equals(userSession.getUsername()) && pediatrician.getPasswordPediatrician().equals(userSession.getPassword())) {
                    returnPediatrician = pediatrician;
                }
            }
        }
        return returnPediatrician;
    }
}
