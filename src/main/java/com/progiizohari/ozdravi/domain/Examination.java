package com.progiizohari.ozdravi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.sql.Timestamp;

@Entity
public class Examination {

    @Id
    @Column(length = 5)
    private String examinationId;

    @NotNull
    private String diagnosis;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Timestamp dateOfExamination;

    @NotNull
    @Pattern(regexp = "[DN]")
    @Column(length = 1)
    private Character medicalCertificate;

    @NotNull
    @Pattern(regexp = "[DN]")
    @Column(length = 1)
    private Character parentMedicalLeave;

    @ManyToOne
    @JoinColumn(name = "recordId")
    private MedicalRecord medicalRecord;

    public Examination() {
    }

    public Examination(String examinationId, String diagnosis, Timestamp dateOfExamination, Character medicalCertificate, Character parentMedicalLeave, MedicalRecord medicalRecord) {
        this.examinationId = examinationId;
        this.diagnosis = diagnosis;
        this.dateOfExamination = dateOfExamination;
        this.medicalCertificate = medicalCertificate;
        this.parentMedicalLeave = parentMedicalLeave;
        this.medicalRecord = medicalRecord;
    }

    public String getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(String examinationId) {
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

    public Character getMedicalCertificate() {
        return medicalCertificate;
    }

    public void setMedicalCertificate(Character medicalCertificate) {
        this.medicalCertificate = medicalCertificate;
    }

    public Character getParentMedicalLeave() {
        return parentMedicalLeave;
    }

    public void setParentMedicalLeave(Character parentMedicalLeave) {
        this.parentMedicalLeave = parentMedicalLeave;
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
                ", parentMedicalLeave=" + parentMedicalLeave +
                ", medicalRecord=" + medicalRecord +
                '}';
    }
}
