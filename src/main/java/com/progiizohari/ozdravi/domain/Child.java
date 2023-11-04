package com.progiizohari.ozdravi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

@Entity
public class Child {

    @Id
    @Pattern(regexp = "^[0-9]{11}$")
    @Column(length = 11)
    private String OIB;

    @NotNull
    private String nameChild;

    @NotNull
    private String lastNameChild;

    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dateOfBirthChild;

    @NotNull
    private String educationalInstitution;

    @Column(unique = true, nullable = false)
    @Email
    private String emailEducationalInstitution;

    @ManyToOne
    @JoinColumn(name = "parent_OIB")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "pediatricanId")
    private Pediatrician pediatrician;

    @OneToOne(mappedBy = "child", cascade = CascadeType.ALL)
    private ChildMedicalRecord medicalRecord;

    public Child() {
    }

    public Child(String OIB, String nameChild, String lastNameChild, Date dateOfBirthChild, String educationalInstitution, String emailEducationalInstitution) {
        this.OIB = OIB;
        this.nameChild = nameChild;
        this.lastNameChild = lastNameChild;
        this.dateOfBirthChild = dateOfBirthChild;
        this.educationalInstitution = educationalInstitution;
        this.emailEducationalInstitution = emailEducationalInstitution;
    }

    public String getOIB() {
        return OIB;
    }

    public void setOIB(String OIB) {
        this.OIB = OIB;
    }

    public String getNameChild() {
        return nameChild;
    }

    public void setNameChild(String nameChild) {
        this.nameChild = nameChild;
    }

    public String getLastNameChild() {
        return lastNameChild;
    }

    public void setLastNameChild(String lastNameChild) {
        this.lastNameChild = lastNameChild;
    }

    public Date getDateOfBirthChild() {
        return dateOfBirthChild;
    }

    public void setDateOfBirthChild(Date dateOfBirthChild) {
        this.dateOfBirthChild = dateOfBirthChild;
    }

    public String getEducationalInstitution() {
        return educationalInstitution;
    }

    public void setEducationalInstitution(String educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }

    public String getEmailEducationalInstitution() {
        return emailEducationalInstitution;
    }

    public void setEmailEducationalInstitution(String emailEducationalInstitution) {
        this.emailEducationalInstitution = emailEducationalInstitution;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Pediatrician getPediatrician() {
        return pediatrician;
    }

    public void setPediatrician(Pediatrician pediatrician) {
        this.pediatrician = pediatrician;
    }

    public ChildMedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(ChildMedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    @Override
    public String toString() {
        return "Child{" +
                "OIB='" + OIB + '\'' +
                ", nameChild='" + nameChild + '\'' +
                ", lastNameChild='" + lastNameChild + '\'' +
                ", dateOfBirthChild=" + dateOfBirthChild +
                ", educationalInstitution='" + educationalInstitution + '\'' +
                ", emailEducationalInstitution='" + emailEducationalInstitution + '\'' +
                ", parent=" + parent +
                ", pediatrician=" + pediatrician +
                ", medicalRecord=" + medicalRecord +
                '}';
    }
}
