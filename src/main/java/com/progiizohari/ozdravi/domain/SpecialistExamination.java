package com.progiizohari.ozdravi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class SpecialistExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examId;

    @NotNull
    private String patientOib;

    @NotNull
    private String examTitle;

    @NotNull
    private String examLocations;

    public SpecialistExamination() {
    }

    public SpecialistExamination(int examId, String patientOib, String examTitle, String examLocations) {
        this.examId = examId;
        this.patientOib = patientOib;
        this.examTitle = examTitle;
        this.examLocations = examLocations;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getPatientOib() {
        return patientOib;
    }

    public void setPatientOib(String patientOib) {
        this.patientOib = patientOib;
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

    @Override
    public String toString() {
        return "SpecialistExamination{" +
                "examId=" + examId +
                ", patientOib='" + patientOib + '\'' +
                ", examTitle='" + examTitle + '\'' +
                ", examLocations='" + examLocations + '\'' +
                '}';
    }
}
