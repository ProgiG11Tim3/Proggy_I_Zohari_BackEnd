package com.progiizohari.ozdravi.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ChildMedicalRecord {

    @Id
    @Column(length = 5)
    private String recordId;

    private String currentDiagnosis;

    private String allergyList;

    @OneToOne
    @JoinColumn(name = "child_OIB", referencedColumnName = "OIB")
    private Child child;

    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
    private List<MedicalReport> medicalReports;

    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
    private List<Examination> examinations;

    public ChildMedicalRecord() {
    }

    public ChildMedicalRecord(String recordId, String currentDiagnosis, String allergyList) {
        this.recordId = recordId;
        this.currentDiagnosis = currentDiagnosis;
        this.allergyList = allergyList;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
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

    @Override
    public String toString() {
        return "ChildMedicalRecord{" +
                "recordId='" + recordId + '\'' +
                ", currentDiagnosis='" + currentDiagnosis + '\'' +
                ", allergyList='" + allergyList + '\'' +
                ", child=" + child +
                ", medicalReports=" + medicalReports +
                ", examinations=" + examinations +
                '}';
    }
}
