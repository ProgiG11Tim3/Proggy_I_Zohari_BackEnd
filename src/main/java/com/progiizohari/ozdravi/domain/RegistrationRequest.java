package com.progiizohari.ozdravi.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RegistrationRequest {
    private String name;
    private String surname;
    private String OIB;
    private String dateOfBirth;
    private String placeOfResidence;
    private String postalCode;
    private String phoneNumber;
    private String emailAddress;
    private String username;
    private String password;
    private String employerEmailAddress;

    public RegistrationRequest() {
    }

    public RegistrationRequest(String name, String surname, String OIB, String dateOfBirth, String placeOfResidence, String postalCode, String phoneNumber, String emailAddress, String username, String password, String employerEmailAddress) {
        this.name = name;
        this.surname = surname;
        this.OIB = OIB;
        this.dateOfBirth = dateOfBirth;
        this.placeOfResidence = placeOfResidence;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.employerEmailAddress = employerEmailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getOIB() {
        return OIB;
    }

    public void setOIB(String OIB){
        this.OIB = OIB;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public void setPlaceOfResidence(String placeOfResidence){
        this.placeOfResidence = placeOfResidence;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmployerEmailAddress() {
        return employerEmailAddress;
    }

    public void setEmployerEmailAddress(String employerEmailAddress){
        this.employerEmailAddress = employerEmailAddress;
    }

    public Parent toParent(int ID) {
        // formatter for string to date conversion
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm-dd-yyyy");
        formatter = formatter.withLocale(Locale.UK);

        Doctor doctor = new Doctor();
        List<Child> children = new ArrayList<>();
        Parent parent = new Parent(OIB, name, surname, LocalDate.parse(dateOfBirth, formatter),
                username, password, phoneNumber, emailAddress, Integer.parseInt(postalCode),
                placeOfResidence, employerEmailAddress, doctor, children);
        return parent;
    }
}
