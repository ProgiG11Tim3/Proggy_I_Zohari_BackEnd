package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.LoginSession;

import java.util.List;

public interface LoginSessionService {
    public String add(String username, String password, String role, String session);
    public String add(LoginSession loginSession);
    public List<LoginSession> getAll();
    public LoginSession getUserOfSession(String sessionID);
    public List<String> getAllSessionsOfUser(String username, String password, String role);
    public boolean checkSession(String username, String password, String role, String session);
    public boolean checkSession(LoginSession loginSession);
    public void remove(LoginSession loginSession);
    public void remove(String username, String password, String role, String session);
}
