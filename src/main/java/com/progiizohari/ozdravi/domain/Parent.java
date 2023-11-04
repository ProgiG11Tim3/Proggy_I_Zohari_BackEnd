package com.progiizohari.ozdravi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


import java.util.Date;
import java.util.List;

@Entity
public class Parent {

    @Id
    @Pattern(regexp = "^[0-9]{11}$")
    @Column(length = 11)
    private String OIB;

    @NotNull
    private String nameParent;

    @NotNull
    private String lastNameParent;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dateOfBirthParent;

    @Column(unique = true, nullable = false)
    private String userNameParent;

    @NotNull
    private String passwordParent;

    @Column(unique = true)
    private String phoneNumberParent;

    @Column(unique = true, nullable = false)
    @Email
    private String emailParent;

    @NotNull
    private Integer postalCode;

    @NotNull
    private String placeOfResidence;

    @ManyToOne
    @JoinColumn(name = "employerId")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;


    public Parent() {
    }

    public Parent(String OIB, String nameParent, String lastNameParent, Date dateOfBirthParent, String userNameParent, String passwordParent, String phoneNumberParent, String emailParent, Integer postalCode, String placeOfResidence) {
        this.OIB = OIB;
        this.nameParent = nameParent;
        this.lastNameParent = lastNameParent;
        this.dateOfBirthParent = dateOfBirthParent;
        this.userNameParent = userNameParent;
        this.passwordParent = passwordParent;
        this.phoneNumberParent = phoneNumberParent;
        this.emailParent = emailParent;
        this.postalCode = postalCode;
        this.placeOfResidence = placeOfResidence;
    }

    public String getOIB() {
        return OIB;
    }

    public void setOIB(String OIB) {
        this.OIB = OIB;
    }

    public String getNameParent() {
        return nameParent;
    }

    public void setNameParent(String nameParent) {
        this.nameParent = nameParent;
    }

    public String getLastNameParent() {
        return lastNameParent;
    }

    public void setLastNameParent(String lastNameParent) {
        this.lastNameParent = lastNameParent;
    }

    public Date getDateOfBirthParent() {
        return dateOfBirthParent;
    }

    public void setDateOfBirthParent(Date dateOfBirthParent) {
        this.dateOfBirthParent = dateOfBirthParent;
    }

    public String getUserNameParent() {
        return userNameParent;
    }

    public void setUserNameParent(String userNameParent) {
        this.userNameParent = userNameParent;
    }

    public String getPasswordParent() {
        return passwordParent;
    }

    public void setPasswordParent(String passwordParent) {
        this.passwordParent = passwordParent;
    }

    public String getPhoneNumberParent() {
        return phoneNumberParent;
    }

    public void setPhoneNumberParent(String phoneNumberParent) {
        this.phoneNumberParent = phoneNumberParent;
    }

    public String getEmailParent() {
        return emailParent;
    }

    public void setEmailParent(String emailParent) {
        this.emailParent = emailParent;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "OIB='" + OIB + '\'' +
                ", nameParent='" + nameParent + '\'' +
                ", lastNameParent='" + lastNameParent + '\'' +
                ", dateOfBirthParent=" + dateOfBirthParent +
                ", userNameParent='" + userNameParent + '\'' +
                ", passwordParent='" + passwordParent + '\'' +
                ", phoneNumberParent='" + phoneNumberParent + '\'' +
                ", emailParent='" + emailParent + '\'' +
                ", postalCode=" + postalCode +
                ", placeOfResidence='" + placeOfResidence + '\'' +
                ", employer=" + employer +
                ", doctor=" + doctor +
                ", children=" + children +
                '}';
    }
}
