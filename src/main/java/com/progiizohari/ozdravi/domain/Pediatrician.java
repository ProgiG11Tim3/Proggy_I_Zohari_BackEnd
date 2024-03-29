package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private String passwordPediatrician;

    @Column(unique = true)
    private String phoneNumberPediatrician;

    @Column(unique = true, nullable = false)
    @Email
    private String emailPediatrician;

    @OneToMany(mappedBy = "pediatrician", cascade = CascadeType.ALL)
    @JsonIgnore
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

    public boolean equalVariables(Pediatrician pediatrician)
    {
        return this.namePediatrician.equals(pediatrician.getNamePediatrician()) &&
                this.lastNamePediatrician.equals(pediatrician.getLastNamePediatrician()) &&
                this.dateOfBirthPediatrician.equals(pediatrician.getDateOfBirthPediatrician()) &&
                this.userNamePediatrician.equals(pediatrician.getUserNamePediatrician()) &&
                this.passwordPediatrician.equals(pediatrician.getPasswordPediatrician()) &&
                this.phoneNumberPediatrician.equals(pediatrician.getPhoneNumberPediatrician()) &&
                this.emailPediatrician.equals(pediatrician.getEmailPediatrician());
    }

    @Override
    public String toString() {
        return "Pediatrician{" +
                "Id='" + pediatricianId + '\'' +
                ", name='" + namePediatrician + '\'' +
                ", lastName='" + lastNamePediatrician + '\'' +
                ", dateOfBirth=" + dateOfBirthPediatrician +
                ", userName='" + userNamePediatrician + '\'' +
                ", password='" + passwordPediatrician + '\'' +
                ", phoneNumber='" + phoneNumberPediatrician + '\'' +
                ", email='" + emailPediatrician + '\'' +
                ", children=" + children +
                '}';
    }

    public String toJson() {
        return "{" +
                "\"pediatricianId\":" + pediatricianId +
                ", \"namePediatrician\":\"" + namePediatrician + '\"' +
                ", \"lastNamePediatrician\":\"" + lastNamePediatrician + '\"' +
                ", \"dateOfBirthPediatrician\":\"" + dateOfBirthPediatrician + '\"' +
                ", \"userNamePediatrician\":\"" + userNamePediatrician + '\"' +
                ", \"passwordPediatrician\":\"" + passwordPediatrician + '\"' +
                ", \"phoneNumberPediatrician\":\"" + phoneNumberPediatrician + '\"' +
                ", \"emailPediatrician\":\"" + emailPediatrician + '\"' +
                ", \"children\":" + children +
                '}';
    }

    public String toJsonIDs() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"pediatricianId\":").append(pediatricianId)
                .append(", \"namePediatrician\":\"").append(namePediatrician).append("\"")
                .append(", \"lastNamePediatrician\":\"").append(lastNamePediatrician).append("\"")
                .append(", \"dateOfBirthPediatrician\":\"").append(dateOfBirthPediatrician).append("\"")
                .append(", \"userNamePediatrician\":\"").append(userNamePediatrician).append("\"")
                .append(", \"passwordPediatrician\":\"").append(passwordPediatrician).append("\"")
                .append(", \"phoneNumberPediatrician\":\"").append(phoneNumberPediatrician).append("\"")
                .append(", \"emailPediatrician\":\"").append(emailPediatrician).append("\"");

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

        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }

}
