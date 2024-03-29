package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
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
    private LocalDate dateOfBirthDoctor;

    @Column(unique = true, nullable = false)
    private String userNameDoctor;

    @NotNull
    @JsonIgnore
    private String passwordDoctor;

    @Column(unique = true)
    private String phoneNumberDoctor;

    @Column(unique = true, nullable = false)
    @Email
    private String emailDoctor;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Parent> parents;

    public Doctor() {
    }

    public Doctor(String nameDoctor, String lastNameDoctor, LocalDate dateOfBirthDoctor, String userNameDoctor, String passwordDoctor, String phoneNumberDoctor, String emailDoctor, List<Parent> parents, List<SickLeaveRecommendation> sickLeaveRecommendations) {        this.nameDoctor = nameDoctor;
        this.lastNameDoctor = lastNameDoctor;
        this.dateOfBirthDoctor = dateOfBirthDoctor;
        this.userNameDoctor = userNameDoctor;
        this.passwordDoctor = passwordDoctor;
        this.phoneNumberDoctor = phoneNumberDoctor;
        this.emailDoctor = emailDoctor;
        this.parents = parents;
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

    public List<Parent> getParents() {
        return parents;
    }

    public boolean addParent(Parent parent) {
        return parents.add(parent);
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }


    public boolean equalVariables(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return nameDoctor.equals(doctor.getNameDoctor()) &&
                lastNameDoctor.equals(doctor.getLastNameDoctor()) &&
                dateOfBirthDoctor.equals(doctor.getDateOfBirthDoctor()) &&
                userNameDoctor.equals(doctor.getUserNameDoctor()) &&
                passwordDoctor.equals(doctor.getPasswordDoctor()) &&
                phoneNumberDoctor.equals(doctor.getPhoneNumberDoctor()) &&
                emailDoctor.equals(doctor.getEmailDoctor());
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Id='" + doctorId + '\'' +
                ", name='" + nameDoctor + '\'' +
                ", lastName='" + lastNameDoctor + '\'' +
                ", dateOfBirth=" + dateOfBirthDoctor +
                ", userName='" + userNameDoctor + '\'' +
                ", password='" + passwordDoctor + '\'' +
                ", phoneNumber='" + phoneNumberDoctor + '\'' +
                ", email='" + emailDoctor + '\'' +
                ", parents=" + parents +
                '}';
    }

    public String toJson() {
        return "{" +
                "\"doctorId\":" + doctorId +
                ", \"nameDoctor\":\"" + nameDoctor + '\"' +
                ", \"lastNameDoctor\":\"" + lastNameDoctor + '\"' +
                ", \"dateOfBirthDoctor\":\"" + dateOfBirthDoctor + '\"' +
                ", \"userNameDoctor\":\"" + userNameDoctor + '\"' +
                ", \"passwordDoctor\":\"" + passwordDoctor + '\"' +
                ", \"phoneNumberDoctor\":\"" + phoneNumberDoctor + '\"' +
                ", \"emailDoctor\":\"" + emailDoctor + '\"' +
                ", \"parents\":" + parents +
                '}';
    }

    public String toJsonIDs() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"doctorId\":").append(doctorId)
                .append(", \"nameDoctor\":\"").append(nameDoctor).append("\"")
                .append(", \"lastNameDoctor\":\"").append(lastNameDoctor).append("\"")
                .append(", \"dateOfBirthDoctor\":\"").append(dateOfBirthDoctor).append("\"")
                .append(", \"userNameDoctor\":\"").append(userNameDoctor).append("\"")
                .append(", \"passwordDoctor\":\"").append(passwordDoctor).append("\"")
                .append(", \"phoneNumberDoctor\":\"").append(phoneNumberDoctor).append("\"")
                .append(", \"emailDoctor\":\"").append(emailDoctor).append("\"");

        // Handle parentsIDs
        if (!parents.isEmpty()) {
            jsonBuilder.append(", \"parentsIDs\": [");
            for (Parent parent : parents) {
                jsonBuilder.append(parent.getParentId()).append(",");
            }
            // Remove the trailing comma if there are parents
            jsonBuilder.setLength(jsonBuilder.length() - 1);
            jsonBuilder.append("]");
        } else {
            jsonBuilder.append(", \"parentsIDs\": []");
        }

        /*// Handle sickLeaveRecommendationsIDs
        if (!sickLeaveRecommendations.isEmpty()) {
            jsonBuilder.append(", \"sickLeaveRecommendationsIDs\": [");
            for (SickLeaveRecommendation recommendation : sickLeaveRecommendations) {
                jsonBuilder.append(recommendation.getRecommendationId()).append(",");
            }
            // Remove the trailing comma if there are recommendations
            jsonBuilder.setLength(jsonBuilder.length() - 1);
            jsonBuilder.append("]");
        } else {
            jsonBuilder.append(", \"sickLeaveRecommendationsIDs\": []");
        }*/

        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }

}
