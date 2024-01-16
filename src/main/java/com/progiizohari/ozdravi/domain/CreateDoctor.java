package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class CreateDoctor {
    private String nameDoctor;
    private String lastNameDoctor;
    private LocalDate dateOfBirthDoctor;
    private String userNameDoctor;
    private String passwordDoctor;
    private String phoneNumberDoctor;
    private String emailDoctor;

    public CreateDoctor() {
    }

    public CreateDoctor(String nameDoctor, String lastNameDoctor, LocalDate dateOfBirthDoctor, String userNameDoctor, String passwordDoctor, String phoneNumberDoctor, String emailDoctor) {
        this.nameDoctor = nameDoctor;
        this.lastNameDoctor = lastNameDoctor;
        this.dateOfBirthDoctor = dateOfBirthDoctor;
        this.userNameDoctor = userNameDoctor;
        this.passwordDoctor = passwordDoctor;
        this.phoneNumberDoctor = phoneNumberDoctor;
        this.emailDoctor = emailDoctor;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public String getLastNameDoctor() {
        return lastNameDoctor;
    }

    public void setLastNameDoctor(String lastNameDoctor) {
        this.lastNameDoctor = lastNameDoctor;
    }

    public LocalDate getDateOfBirthDoctor() {
        return dateOfBirthDoctor;
    }

    public void setDateOfBirthDoctor(LocalDate dateOfBirthDoctor) {
        this.dateOfBirthDoctor = dateOfBirthDoctor;
    }

    public String getUserNameDoctor() {
        return userNameDoctor;
    }

    public void setUserNameDoctor(String userNameDoctor) {
        this.userNameDoctor = userNameDoctor;
    }

    public String getPasswordDoctor() {
        return passwordDoctor;
    }

    public void setPasswordDoctor(String passwordDoctor) {
        this.passwordDoctor = passwordDoctor;
    }

    public String getPhoneNumberDoctor() {
        return phoneNumberDoctor;
    }

    public void setPhoneNumberDoctor(String phoneNumberDoctor) {
        this.phoneNumberDoctor = phoneNumberDoctor;
    }

    public String getEmailDoctor() {
        return emailDoctor;
    }

    public void setEmailDoctor(String emailDoctor) {
        this.emailDoctor = emailDoctor;
    }

    @Override
    public String toString() {
        return "CreateDoctor{" +
                "nameDoctor='" + nameDoctor + '\'' +
                ", lastNameDoctor='" + lastNameDoctor + '\'' +
                ", dateOfBirthDoctor=" + dateOfBirthDoctor +
                ", userNameDoctor='" + userNameDoctor + '\'' +
                ", passwordDoctor='" + passwordDoctor + '\'' +
                ", phoneNumberDoctor='" + phoneNumberDoctor + '\'' +
                ", emailDoctor='" + emailDoctor + '\'' +
                '}';
    }
}
