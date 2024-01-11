package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.LoginSession;

import java.util.List;

public interface LoginSessionService {
    public String add(String username, String password, String role, String session);
    public String add(LoginSession loginSession);
    public List<LoginSession> getAll();
    // TODO: if we decide to only have singular login, contact Dino to refactor this and login session service
    public List<LoginSession> getAllUsersOfSession(String sessionID);
    // TODO: if we decide to only have singular login, contact Dino to refactor this and login session service
    public List<String> getAllSessionsOfUser(String username, String password, String role);
    public boolean checkSession(String username, String password, String role, String session);
    public boolean checkSession(LoginSession loginSession);
}
