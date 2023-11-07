package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    @NotNull
    private String nameDoctor;

    @NotNull
    private String lastNameDoctor;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dateOfBirthDoctor;

    @Column(unique = true, nullable = false)
    private String userNameDoctor;

    @NotNull
    private String passwordDoctor;

    @Column(unique = true)
    private String phoneNumberDoctor;

    @Column(unique = true, nullable = false)
    @Email
    private String emailDoctor;

    @OneToMany(mappedBy = "doctor")
    private List<Parent> parents;

    public Doctor() {
    }

    public Doctor(int doctorId, String nameDoctor, String lastNameDoctor, Date dateOfBirthDoctor, String userNameDoctor, String passwordDoctor, String phoneNumberDoctor, String emailDoctor) {
        this.doctorId = doctorId;
        this.nameDoctor = nameDoctor;
        this.lastNameDoctor = lastNameDoctor;
        this.dateOfBirthDoctor = dateOfBirthDoctor;
        this.userNameDoctor = userNameDoctor;
        this.passwordDoctor = passwordDoctor;
        this.phoneNumberDoctor = phoneNumberDoctor;
        this.emailDoctor = emailDoctor;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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

    public Date getDateOfBirthDoctor() {
        return dateOfBirthDoctor;
    }

    public void setDateOfBirthDoctor(Date dateOfBirthDoctor) {
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

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", nameDoctor='" + nameDoctor + '\'' +
                ", lastNameDoctor='" + lastNameDoctor + '\'' +
                ", dateOfBirthDoctor=" + dateOfBirthDoctor +
                ", userNameDoctor='" + userNameDoctor + '\'' +
                ", passwordDoctor='" + passwordDoctor + '\'' +
                ", phoneNumberDoctor='" + phoneNumberDoctor + '\'' +
                ", emailDoctor='" + emailDoctor + '\'' +
                ", parents=" + parents +
                '}';
    }
}
