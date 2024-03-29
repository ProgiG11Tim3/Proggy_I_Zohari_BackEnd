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
    @JsonIgnore
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

    @OneToOne(mappedBy = "parent")
    private MedicalRecord medicalRecord;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;


    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Child> children;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Notification> notifications;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SickLeaveRecommendation> sickLeaveRecommendations;

    public Parent() {}

    public Parent(String OIB, String nameParent, String lastNameParent, LocalDate dateOfBirthParent, String userNameParent, String passwordParent, String phoneNumberParent, String emailParent, Integer postalCode, String placeOfResidence, String employerEmail, MedicalRecord medicalRecord, Doctor doctor, List<Child> children, List<SickLeaveRecommendation> sickLeaveRecommendations) {
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
        this.medicalRecord = medicalRecord;
        this.doctor = doctor;
        this.children = children;
        this.sickLeaveRecommendations = sickLeaveRecommendations;
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

    public List<SickLeaveRecommendation> getSickLeaveRecommendations() {
        return sickLeaveRecommendations;
    }

    public void setSickLeaveRecommendations(List<SickLeaveRecommendation> sickLeaveRecommendations) {
        this.sickLeaveRecommendations = sickLeaveRecommendations;
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

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
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

    public String toJson() {
        return "{" +
                "\"parentId\":" + parentId +
                ", \"OIB\":\"" + OIB + '\"' +
                ", \"nameParent\":\"" + nameParent + '\"' +
                ", \"lastNameParent\":\"" + lastNameParent + '\"' +
                ", \"dateOfBirthParent\":\"" + dateOfBirthParent + '\"' +
                ", \"userNameParent\":\"" + userNameParent + '\"' +
                ", \"passwordParent\":\"" + passwordParent + '\"' +
                ", \"phoneNumberParent\":\"" + phoneNumberParent + '\"' +
                ", \"emailParent\":\"" + emailParent + '\"' +
                ", \"postalCode\":" + postalCode +
                ", \"placeOfResidence\":\"" + placeOfResidence + '\"' +
                ", \"employerEmail\":\"" + employerEmail + '\"' +
                ", \"doctor\":" + doctor +
                ", \"children\":" + children +
                '}';
    }

    public String toJsonIDs() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"parentId\":").append(parentId)
                .append(", \"OIB\":\"").append(OIB).append("\"")
                .append(", \"nameParent\":\"").append(nameParent).append("\"")
                .append(", \"lastNameParent\":\"").append(lastNameParent).append("\"")
                .append(", \"dateOfBirthParent\":\"").append(dateOfBirthParent).append("\"")
                .append(", \"userNameParent\":\"").append(userNameParent).append("\"")
                .append(", \"passwordParent\":\"").append(passwordParent).append("\"")
                .append(", \"phoneNumberParent\":\"").append(phoneNumberParent).append("\"")
                .append(", \"emailParent\":\"").append(emailParent).append("\"")
                .append(", \"postalCode\":").append(postalCode)
                .append(", \"placeOfResidence\":\"").append(placeOfResidence).append("\"")
                .append(", \"employerEmail\":\"").append(employerEmail).append("\"")
                .append(", \"doctorID\":").append(doctor.getDoctorId());

        // Handle childrenIDs
        if (!children.isEmpty()) {
            jsonBuilder.append(", \"childrenIDs\": [");
            for (Child child : children) {
                jsonBuilder.append(child.getChildId()).append(",");
            }
            // Remove the trailing comma if there are children
            jsonBuilder.setLength(jsonBuilder.length() - 1);
            jsonBuilder.append("]");
        } else {
            jsonBuilder.append(", \"childrenIDs\": []");
        }

        // Handle notificationsIDs
        if (!notifications.isEmpty()) {
            jsonBuilder.append(", \"notificationsIDs\": [");
            for (Notification notification : notifications) {
                jsonBuilder.append(notification.getNotificationId()).append(",");
            }
            // Remove the trailing comma if there are notifications
            jsonBuilder.setLength(jsonBuilder.length() - 1);
            jsonBuilder.append("]");
        } else {
            jsonBuilder.append(", \"notificationsIDs\": []");
        }

        // Handle sickLeaveRecommendationsIDs
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
        }

        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}
