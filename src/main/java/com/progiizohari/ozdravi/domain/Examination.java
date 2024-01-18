package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.sql.Timestamp;

@Entity
public class Examination {

    @Id
    @Column(length = 5)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int examinationId;

    @NotNull
    private String diagnosis;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Timestamp dateOfExamination;

    @NotNull
    @Pattern(regexp = "[DN]")
    @Column(length = 1)
    private String medicalCertificate;

    @ManyToOne
    @JoinColumn(name = "recordId")
    private MedicalRecord medicalRecord;

    public Examination() {
    }

    public Examination(String diagnosis, Timestamp dateOfExamination, String medicalCertificate, MedicalRecord medicalRecord) {
        this.diagnosis = diagnosis;
        this.dateOfExamination = dateOfExamination;
        this.medicalCertificate = medicalCertificate;
        this.medicalRecord = medicalRecord;
    }

    public int getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(int examinationId) {
        this.examinationId = examinationId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Timestamp getDateOfExamination() {
        return dateOfExamination;
    }

    public void setDateOfExamination(Timestamp dateOfExamination) {
        this.dateOfExamination = dateOfExamination;
    }

    public String getMedicalCertificate() {
        return medicalCertificate;
    }

    public void setMedicalCertificate(String medicalCertificate) {
        this.medicalCertificate = medicalCertificate;
    }


    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    @Override
    public String toString() {
        return "Examination{" +
                "examinationId='" + examinationId + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", dateOfExamination=" + dateOfExamination +
                ", medicalCertificate=" + medicalCertificate +
                ", medicalRecord=" + medicalRecord +
                '}';
    }
}
