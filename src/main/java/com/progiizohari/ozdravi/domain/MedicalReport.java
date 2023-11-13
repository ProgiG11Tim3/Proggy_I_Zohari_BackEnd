package com.progiizohari.ozdravi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

@Entity
public class MedicalReport {

    @Id
    @Column(length = 5)
    private String reportId;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Timestamp dateOfReport;

    @NotNull
    private String reportInformation;

    @ManyToOne
    @JoinColumn(name = "recordId")
    private MedicalRecord medicalRecord;

    public MedicalReport() {
    }

    public MedicalReport(String reportId, Timestamp dateOfReport, String reportInformation) {
        this.reportId = reportId;
        this.dateOfReport = dateOfReport;
        this.reportInformation = reportInformation;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Timestamp getDateOfReport() {
        return dateOfReport;
    }

    public void setDateOfReport(Timestamp dateOfReport) {
        this.dateOfReport = dateOfReport;
    }

    public String getReportInformation() {
        return reportInformation;
    }

    public void setReportInformation(String reportInformation) {
        this.reportInformation = reportInformation;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    @Override
    public String toString() {
        return "MedicalReport{" +
                "reportId='" + reportId + '\'' +
                ", dateOfReport=" + dateOfReport +
                ", reportInformation='" + reportInformation + '\'' +
                ", medicalRecord=" + medicalRecord +
                '}';
    }
}
