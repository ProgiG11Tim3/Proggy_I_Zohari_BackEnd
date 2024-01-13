package com.progiizohari.ozdravi.domain;

public class ChoseProfileEntry {
    private String role;
    private String name;
    private String surname;
    private String oib;
    private String dateOfBirth;
    private String link;

    public ChoseProfileEntry(String role, String name, String surname, String oib, String dateOfBirth, String link) {
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.oib = oib;
        this.dateOfBirth = dateOfBirth;
        this.link = link;
    }

    public ChoseProfileEntry() {
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getOib() {
        return oib;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLink() {
        return link;
    }
}
