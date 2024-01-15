package com.progiizohari.ozdravi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class SpecialistExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examId;

    @NotNull
    private String examTitle;

    @NotNull
    private String examLocations;

    @ManyToOne
    @JoinColumn(name = "recordId")
    private MedicalRecord medicalRecord;

    public SpecialistExamination() {
    }

    public SpecialistExamination(String examTitle, String examLocations, MedicalRecord medicalRecord) {
        this.examTitle = examTitle;
        this.examLocations = examLocations;
        this.medicalRecord = medicalRecord;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }


    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public String getExamLocations() {
        return examLocations;
    }

    public void setExamLocations(String examLocations) {
        this.examLocations = examLocations;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    @Override
    public String toString() {
        return "SpecialistExamination{" +
                "examId=" + examId +
                ", examTitle='" + examTitle + '\'' +
                ", examLocations='" + examLocations + '\'' +
                ", medicalRecord=" + medicalRecord +
                '}';
    }
}
