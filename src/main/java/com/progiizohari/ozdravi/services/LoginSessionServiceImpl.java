package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.LoginSession;
import com.progiizohari.ozdravi.repositories.LoginSesssionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginSessionServiceImpl implements LoginSessionService {

    @Autowired
    private LoginSesssionRepository repository;

    @Override
    public String add(String username, String password, String role, String session) {
        repository.save(new LoginSession(username, password, role, session));
        return "Login session successfully added!";
    }

    @Override
    public String add(LoginSession loginSession) {
        repository.save(loginSession);
        return "Login session successfully added!";
    }

    @Override
    public List<LoginSession> getAll() {
        return repository.findAll();
    }

    @Override
    public List<LoginSession> getAllUsersOfSession(String sessionID) {
        List<LoginSession> returnList = new ArrayList<>();
        List<LoginSession> loginSessions = repository.findAll();
        for (LoginSession entry : loginSessions) {
            if (entry.getSession().equals(sessionID)) {
                returnList.add(entry);
            }
        }
        return returnList;
    }

    @Override
    public List<String> getAllSessionsOfUser(String username, String password, String role) {
        List<String> returnList = new ArrayList<>();
        List<LoginSession> loginSessions = repository.findAll();
        for (LoginSession entry : loginSessions) {
            if (entry.getUsername().equals(username) && entry.getPassword().equals(password) && entry.getRole().equals(role)) {
                returnList.add(entry.getSession());
            }
        }
        return returnList;
    }

    @Override
    public boolean checkSession(String username, String password, String role, String session) {
        List<LoginSession> loginSessions = repository.findAll();
        for (LoginSession entry : loginSessions) {
            if (entry.CheckLoginSession(username, password, role, session)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkSession(LoginSession loginSession) {
        for (LoginSession entry : repository.findAll()) {
            if (entry.CheckLoginSession(loginSession)) {
                return true;
            }
        }
        return false;
    }
}
