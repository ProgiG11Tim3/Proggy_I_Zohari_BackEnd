package com.progiizohari.ozdravi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
public class Pediatrician {

    @Id
    @Column(length = 5)
    private String pediatricianId;

    @NotNull
    private String namePediatrician;

    @NotNull
    private String lastNamePediatrician;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dateOfBirthPediatrician;

    @Column(unique = true, nullable = false)
    private String userNamePediatrician;

    @NotNull
    private String passwordPediatrician;

    @Column(unique = true)
    private String phoneNumberPediatrician;

    @Column(unique = true, nullable = false)
    @Email
    private String emailPediatrician;

    @OneToMany(mappedBy = "pediatrician")
    private List<Child> children;

    public Pediatrician() {
    }

    public String getPediatricianId() {
        return pediatricianId;
    }

    public void setPediatricianId(String pediatricianId) {
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

    public Date getDateOfBirthPediatrician() {
        return dateOfBirthPediatrician;
    }

    public void setDateOfBirthPediatrician(Date dateOfBirthPediatrician) {
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
