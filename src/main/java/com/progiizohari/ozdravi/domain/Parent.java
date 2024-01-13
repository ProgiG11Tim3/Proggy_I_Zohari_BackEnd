package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parentId;

    @Pattern(regexp = "^[0-9]{11}$")
    @Column(length = 11, unique = true)
    @NotNull
    private String OIB;

    @NotNull
    private String nameParent;

    @NotNull
    private String lastNameParent;

    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirthParent;

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


    @NotNull
    private String employerEmail;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    @JsonIgnore
    private Doctor doctor;


    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Child> children;

    public Parent() {}

    public Parent(String OIB, String nameParent, String lastNameParent, LocalDate dateOfBirthParent, String userNameParent, String passwordParent, String phoneNumberParent, String emailParent, Integer postalCode, String placeOfResidence, String employerEmail, Doctor doctor, List<Child> children) {
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
        this.employerEmail = employerEmail;
        this.doctor = doctor;
        this.children = children;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getOIB() {
        return OIB;
    }

    public String getNameParent() {
        return nameParent;
    }

    public String getLastNameParent() {
        return lastNameParent;
    }

    public LocalDate getDateOfBirthParent() {
        return dateOfBirthParent;
    }

    public String getUserNameParent() {
        return userNameParent;
    }

    public String getPasswordParent() {
        return passwordParent;
    }

    public String getPhoneNumberParent() {
        return phoneNumberParent;
    }

    public String getEmailParent() {
        return emailParent;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public String getEmployerEmail() {
        return employerEmail;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setOIB(String OIB) {
        this.OIB = OIB;
    }

    public void setNameParent(String nameParent) {
        this.nameParent = nameParent;
    }

    public void setLastNameParent(String lastNameParent) {
        this.lastNameParent = lastNameParent;
    }

    public void setDateOfBirthParent(LocalDate dateOfBirthParent) {
        this.dateOfBirthParent = dateOfBirthParent;
    }

    public void setUserNameParent(String userNameParent) {
        this.userNameParent = userNameParent;
    }

    public void setPasswordParent(String passwordParent) {
        this.passwordParent = passwordParent;
    }

    public void setPhoneNumberParent(String phoneNumberParent) {
        this.phoneNumberParent = phoneNumberParent;
    }

    public void setEmailParent(String emailParent) {
        this.emailParent = emailParent;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public void setPlaceOfResidence(String placeOfResidence) {
        this.placeOfResidence = placeOfResidence;
    }

    public void setEmployerEmail(String employerEmail) {
        this.employerEmail = employerEmail;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public boolean equalVariables(Parent parent)
    {
        if (this.OIB.equals(parent.getOIB()) &&
                this.nameParent.equals(parent.getNameParent()) &&
                this.lastNameParent.equals(parent.getLastNameParent()) &&
                this.dateOfBirthParent.equals(parent.getDateOfBirthParent()) &&
                this.userNameParent.equals(parent.getUserNameParent()) &&
                this.passwordParent.equals(parent.getPasswordParent()) &&
                this.phoneNumberParent.equals(parent.getPhoneNumberParent()) &&
                this.emailParent.equals(parent.getEmailParent()) &&
                this.postalCode.equals(parent.getPostalCode()) &&
                this.placeOfResidence.equals(parent.getPlaceOfResidence()) &&
                this.employerEmail.equals(parent.getEmployerEmail()) &&
                this.doctor.equals(parent.getDoctor()) &&
                this.children.equals(parent.getChildren()))
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Parent{" +
                ", Id " + parentId + '\'' +
                ", OIB='" + OIB + '\'' +
                ", name='" + nameParent + '\'' +
                ", lastName='" + lastNameParent + '\'' +
                ", dateOfBirth=" + dateOfBirthParent +
                ", userName='" + userNameParent + '\'' +
                ", password='" + passwordParent + '\'' +
                ", phoneNumber='" + phoneNumberParent + '\'' +
                ", email='" + emailParent + '\'' +
                ", postalCode=" + postalCode +
                ", placeOfResidence='" + placeOfResidence + '\'' +
                ", employerEmail=" + employerEmail +
                ", doctor=" + doctor +
                ", children=" + children +
                '}';
    }
}
