package com.progiizohari.ozdravi.domain;

public class CurrentActiveUser {
    String name;
    String surname;
    String role;

    public CurrentActiveUser(String name, String surname, String role) {
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public CurrentActiveUser() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
