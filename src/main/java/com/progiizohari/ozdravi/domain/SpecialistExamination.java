package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Set;

@Entity
public class SpecialistExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examId;

    @NotNull
    private String examTitle;

    @ManyToOne
    @JoinColumn(name = "recordId")
    @JsonIgnore
    private MedicalRecord medicalRecord;

    @ManyToMany
    @JoinTable(
            name = "examLocations",
            joinColumns = @JoinColumn(name = "examId", referencedColumnName = "examId"),
            inverseJoinColumns = @JoinColumn(name = "hospitalLocationId", referencedColumnName = "hospitalLocationId")
    )
    private List<HospitalLocation> hospitalLocations;

    public SpecialistExamination() {
    }


    public SpecialistExamination(String examTitle, MedicalRecord medicalRecord, List<HospitalLocation> hospitalLocations) {
        this.examTitle = examTitle;
        this.medicalRecord = medicalRecord;
        this.hospitalLocations = hospitalLocations;
    }

    public int getExamId() {
        return examId;
    }



    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public List<HospitalLocation> getHospitalLocations() {
        return hospitalLocations;
    }

    public void setHospitalLocations(List<HospitalLocation> hospitalLocations) {
        this.hospitalLocations = hospitalLocations;
    }

    @Override
    public String toString() {
        return "SpecialistExamination{" +
                "examId=" + examId +
                ", examTitle='" + examTitle + '\'' +
                ", medicalRecord=" + medicalRecord +
                '}';
    }
}
