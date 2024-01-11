package com.progiizohari.ozdravi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class LoginSession {
    @Id
    private int loginSessionId;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String role;
    @NotNull
    private String session;
    @NotNull
    private boolean active;

    public LoginSession(){

    }

    public LoginSession(String username, String password, String role, String session, boolean active) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.session = session;
        this.active = active;
    }

    public LoginSession(String username, String password, String role, String session) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.session = session;
        this.active = false;
    }

    public LoginSession(LoginSession loginSession){
        this.username = loginSession.username;
        this.password = loginSession.password;
        this.role = loginSession.role;
        this.session = loginSession.session;
        this.active = loginSession.active;
    }

    public boolean CheckLoginSession(String username, String password, String role, String session) {
        return this.username.equals(username) && this.password.equals(password) && this.role.equals(role) && this.session.equals(session);
    }

    public boolean CheckLoginSession(LoginSession loginSession) {
        return this.username.equals(loginSession.username) && this.password.equals(loginSession.password) && this.role.equals(loginSession.role) && this.session.equals(loginSession.session);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getSession() {
        return session;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String toString() {
        return "LoginSession{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", session='" + session + '\'' +
                ", active=" + active +
                '}';
    }
}
