package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreatePediatrician {
    private String namePediatrician;
    private String lastNamePediatrician;
    private LocalDate dateOfBirthPediatrician;
    private String userNamePediatrician;
    private String passwordPediatrician;
    private String phoneNumberPediatrician;
    private String emailPediatrician;

    public CreatePediatrician() {
    }

    public CreatePediatrician(String namePediatrician, String lastNamePediatrician, LocalDate dateOfBirthPediatrician, String userNamePediatrician, String passwordPediatrician, String phoneNumberPediatrician, String emailPediatrician) {
        this.namePediatrician = namePediatrician;
        this.lastNamePediatrician = lastNamePediatrician;
        this.dateOfBirthPediatrician = dateOfBirthPediatrician;
        this.userNamePediatrician = userNamePediatrician;
        this.passwordPediatrician = passwordPediatrician;
        this.phoneNumberPediatrician = phoneNumberPediatrician;
        this.emailPediatrician = emailPediatrician;
    }

    public String getNamePediatrician() {
        return namePediatrician;
    }

    public void setNamePediatrician(String namePediatrician) {
        this.namePediatrician = namePediatrician;
    }

    public String getLastNamePediatrician() {
        return lastNamePediatrician;
    }

    public void setLastNamePediatrician(String lastNamePediatrician) {
        this.lastNamePediatrician = lastNamePediatrician;
    }

    public LocalDate getDateOfBirthPediatrician() {
        return dateOfBirthPediatrician;
    }

    public void setDateOfBirthPediatrician(LocalDate dateOfBirthPediatrician) {
        this.dateOfBirthPediatrician = dateOfBirthPediatrician;
    }

    public String getUserNamePediatrician() {
        return userNamePediatrician;
    }

    public void setUserNamePediatrician(String userNamePediatrician) {
        this.userNamePediatrician = userNamePediatrician;
    }

    public String getPasswordPediatrician() {
        return passwordPediatrician;
    }

    public void setPasswordPediatrician(String passwordPediatrician) {
        this.passwordPediatrician = passwordPediatrician;
    }

    public String getPhoneNumberPediatrician() {
        return phoneNumberPediatrician;
    }

    public void setPhoneNumberPediatrician(String phoneNumberPediatrician) {
        this.phoneNumberPediatrician = phoneNumberPediatrician;
    }

    public String getEmailPediatrician() {
        return emailPediatrician;
    }

    public void setEmailPediatrician(String emailPediatrician) {
        this.emailPediatrician = emailPediatrician;
    }

    @Override
    public String toString() {
        return "CreatePediatrician{" +
                "namePediatrician='" + namePediatrician + '\'' +
                ", lastNamePediatrician='" + lastNamePediatrician + '\'' +
                ", dateOfBirthPediatrician=" + dateOfBirthPediatrician +
                ", userNamePediatrician='" + userNamePediatrician + '\'' +
                ", passwordPediatrician='" + passwordPediatrician + '\'' +
                ", phoneNumberPediatrician='" + phoneNumberPediatrician + '\'' +
                ", emailPediatrician='" + emailPediatrician + '\'' +
                '}';
    }
}
