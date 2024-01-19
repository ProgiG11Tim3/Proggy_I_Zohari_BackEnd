package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class MedicalReport {

    @Id
    @Column(length = 5)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Timestamp dateOfReport;

    @NotNull
    private String reportInformation;

    @ManyToOne
    @JoinColumn(name = "recordId")
    @JsonIgnore
    private MedicalRecord medicalRecord;

    @OneToMany(mappedBy = "medicalReport", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<FileDB> fileDBS;

    public MedicalReport() {
    }

    public MedicalReport(Timestamp dateOfReport, String reportInformation, MedicalRecord medicalRecord, List<FileDB> fileDBS) {
        this.dateOfReport = dateOfReport;
        this.reportInformation = reportInformation;
        this.medicalRecord = medicalRecord;
        this.fileDBS = fileDBS;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
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

    public List<FileDB> getFileDBS() {
        return fileDBS;
    }

    public void setFileDBS(List<FileDB> fileDBS) {
        this.fileDBS = fileDBS;
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

    public boolean equalValues(MedicalReport medicalReport) {
        if (this.dateOfReport.equals(medicalReport.getDateOfReport()) &&
                this.reportInformation.equals(medicalReport.getReportInformation()) &&
                this.medicalRecord.equals(medicalReport.getMedicalRecord()) &&
                this.fileDBS.equals(medicalReport.getFileDBS())) {
            return true;
        }
        return false;
    }
}
