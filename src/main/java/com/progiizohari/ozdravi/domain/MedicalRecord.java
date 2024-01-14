package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordId;

    private String currentDiagnosis;

    private String allergyList;

    @OneToOne
    @JoinColumn(name = "child_OIB")
    private Child child;

    @OneToOne
    @JoinColumn(name = "parent_OIB")
    private Parent parent;

    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MedicalReport> medicalReports;

    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Examination> examinations;

    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<SpecialistExamination> specialistExaminations;

    public MedicalRecord() {
    }

    public MedicalRecord(Parent parent){
        this.parent = parent;
    }

    public MedicalRecord(Child child){
        this.child = child;
    }

    public MedicalRecord(String currentDiagnosis, String allergyList, Child child, Parent parent, List<MedicalReport> medicalReports, List<Examination> examinations) {
        this.currentDiagnosis = currentDiagnosis;
        this.allergyList = allergyList;
        this.child = child;
        this.parent = parent;
        this.medicalReports = medicalReports;
        this.examinations = examinations;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getCurrentDiagnosis() {
        return currentDiagnosis;
    }

    public void setCurrentDiagnosis(String currentDiagnosis) {
        this.currentDiagnosis = currentDiagnosis;
    }

    public String getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(String allergyList) {
        this.allergyList = allergyList;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public List<MedicalReport> getMedicalReports() {
        return medicalReports;
    }

    public void setMedicalReports(List<MedicalReport> medicalReports) {
        this.medicalReports = medicalReports;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations = examinations;
    }

    public List<SpecialistExamination> getSpecialistExaminations() {
        return specialistExaminations;
    }

    public void setSpecialistExaminations(List<SpecialistExamination> specialistExaminations) {
        this.specialistExaminations = specialistExaminations;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "recordId='" + recordId + '\'' +
                ", currentDiagnosis='" + currentDiagnosis + '\'' +
                ", allergyList='" + allergyList + '\'' +
                ", child=" + child +
                ", medicalReports=" + medicalReports +
                ", examinations=" + examinations +
                '}';
    }
}
