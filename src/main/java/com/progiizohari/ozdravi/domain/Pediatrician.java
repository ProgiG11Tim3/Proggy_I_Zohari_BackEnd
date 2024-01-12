package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pediatrician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pediatricianId;

    @NotNull
    private String namePediatrician;

    @NotNull
    private String lastNamePediatrician;

    @Temporal(TemporalType.DATE)
    @NotNull
    private LocalDate dateOfBirthPediatrician;

    @Column(unique = true, nullable = false)
    private String userNamePediatrician;

    @NotNull
    private String passwordPediatrician;

    @Column(unique = true)
    private String phoneNumberPediatrician;

    @Column(unique = true, nullable = false)
    @Email
    private String emailPediatrician;

    @OneToMany(mappedBy = "pediatrician", cascade = CascadeType.ALL)
    private List<Child> children;

    public Pediatrician() {
    }

    public Pediatrician(String namePediatrician, String lastNamePediatrician, LocalDate dateOfBirthPediatrician, String userNamePediatrician, String passwordPediatrician, String phoneNumberPediatrician, String emailPediatrician, List<Child> children) {
        this.namePediatrician = namePediatrician;
        this.lastNamePediatrician = lastNamePediatrician;
        this.dateOfBirthPediatrician = dateOfBirthPediatrician;
        this.userNamePediatrician = userNamePediatrician;
        this.passwordPediatrician = passwordPediatrician;
        this.phoneNumberPediatrician = phoneNumberPediatrician;
        this.emailPediatrician = emailPediatrician;
        this.children = children;
    }

    public int getPediatricianId() {
        return pediatricianId;
    }

    public void setPediatricianId(int pediatricianId) {
        this.pediatricianId = pediatricianId;
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

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Pediatrician{" +
                "pediatricianId='" + pediatricianId + '\'' +
                ", namePediatrician='" + namePediatrician + '\'' +
                ", lastNamePediatrician='" + lastNamePediatrician + '\'' +
                ", dateOfBirthPediatrician=" + dateOfBirthPediatrician +
                ", userNamePediatrician='" + userNamePediatrician + '\'' +
                ", passwordPediatrician='" + passwordPediatrician + '\'' +
                ", phoneNumberPediatrician='" + phoneNumberPediatrician + '\'' +
                ", emailPediatrician='" + emailPediatrician + '\'' +
                ", children=" + children +
                '}';
    }
}
