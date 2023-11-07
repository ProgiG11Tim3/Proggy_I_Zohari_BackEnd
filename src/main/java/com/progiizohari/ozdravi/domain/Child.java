package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int childId;

    @Pattern(regexp = "^[0-9]{11}$")
    @Column(length = 11, unique = true)
    @NotNull
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

    @Column(nullable = false)
    @Email
    private String emailEducationalInstitution;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_OIB")
    private Parent parent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pediatricianId")
    private Pediatrician pediatrician;

    @OneToOne(mappedBy = "child")
    private ChildMedicalRecord medicalRecord;

    public Child() {
    }

    public Child(int childId, String OIB, String nameChild, String lastNameChild, Date dateOfBirthChild, String educationalInstitution, String emailEducationalInstitution, Parent parent, Pediatrician pediatrician, ChildMedicalRecord medicalRecord) {
        this.childId = childId;
        this.OIB = OIB;
        this.nameChild = nameChild;
        this.lastNameChild = lastNameChild;
        this.dateOfBirthChild = dateOfBirthChild;
        this.educationalInstitution = educationalInstitution;
        this.emailEducationalInstitution = emailEducationalInstitution;
        this.parent = parent;
        this.pediatrician = pediatrician;
        this.medicalRecord = medicalRecord;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
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
