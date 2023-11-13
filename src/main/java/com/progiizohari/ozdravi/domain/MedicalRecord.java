package com.progiizohari.ozdravi.domain;

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
    @JoinColumn(name = "child_OIB", referencedColumnName = "OIB")
    private Child child;

    @OneToMany(mappedBy = "medicalRecord")
    private List<MedicalReport> medicalReports;

    @OneToMany(mappedBy = "medicalRecord")
    private List<Examination> examinations;

    public MedicalRecord() {
    }

    public MedicalRecord(int recordId, String currentDiagnosis, String allergyList, Child child, List<MedicalReport> medicalReports, List<Examination> examinations) {
        this.recordId = recordId;
        this.currentDiagnosis = currentDiagnosis;
        this.allergyList = allergyList;
        this.child = child;
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
