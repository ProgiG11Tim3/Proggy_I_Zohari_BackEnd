package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class ChildRegistrationEntry {
    private String OIB;
    private String nameChild;
    private String lastNameChild;
    private LocalDate dateOfBirthChild;
    private String educationalInstitution;
    private String emailEducationalInstitution;
    private String parentOIB;

    public ChildRegistrationEntry(String OIB, String nameChild, String lastNameChild, LocalDate dateOfBirthChild, String educationalInstitution, String emailEducationalInstitution, String parentOIB) {
        this.OIB = OIB;
        this.nameChild = nameChild;
        this.lastNameChild = lastNameChild;
        this.dateOfBirthChild = dateOfBirthChild;
        this.educationalInstitution = educationalInstitution;
        this.emailEducationalInstitution = emailEducationalInstitution;
        this.parentOIB = parentOIB;
    }

    public ChildRegistrationEntry() {
    }

    public String getOIB() {
        return OIB;
    }

    public String getNameChild() {
        return nameChild;
    }

    public String getLastNameChild() {
        return lastNameChild;
    }

    public LocalDate getDateOfBirthChild() {
        return dateOfBirthChild;
    }

    public String getEducationalInstitution() {
        return educationalInstitution;
    }

    public String getEmailEducationalInstitution() {
        return emailEducationalInstitution;
    }

    public String getParentOIB() {
        return parentOIB;
    }

    public void setOIB(String OIB) {
        this.OIB = OIB;
    }

    public void setNameChild(String nameChild) {
        this.nameChild = nameChild;
    }

    public void setLastNameChild(String lastNameChild) {
        this.lastNameChild = lastNameChild;
    }

    public void setDateOfBirthChild(LocalDate dateOfBirthChild) {
        this.dateOfBirthChild = dateOfBirthChild;
    }

    public void setEducationalInstitution(String educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }

    public void setEmailEducationalInstitution(String emailEducationalInstitution) {
        this.emailEducationalInstitution = emailEducationalInstitution;
    }

    public void setParentOIB(String parentOIB) {
        this.parentOIB = parentOIB;
    }

}
