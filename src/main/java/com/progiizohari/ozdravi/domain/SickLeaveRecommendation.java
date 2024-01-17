package com.progiizohari.ozdravi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

@Entity
public class SickLeaveRecommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recommendationId;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @NotNull
    private String recData;

    @NotNull
    private Date sickLeaveStartDate;

    @NotNull
    private String employerEmail;

    @NotNull
    private boolean isApproved;

    public SickLeaveRecommendation() {
    }

    public SickLeaveRecommendation(Doctor doctor, String recData, String employerEmail) {
        this.doctor = doctor;
        this.recData = recData;
        this.employerEmail = employerEmail;
        this.sickLeaveStartDate = new Date(System.currentTimeMillis());
        this.isApproved = false;
    }

    public int getRecommendationId() {
        return recommendationId;
    }

    public Date getSickLeaveStartDate() {
        return sickLeaveStartDate;
    }

    public int daysSinceSickLeaveStartDate() {
        return (int) ((System.currentTimeMillis() - sickLeaveStartDate.getTime()) / (1000 * 60 * 60 * 24));
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getRecData() {
        return recData;
    }

    public void setRecData(String recData) {
        this.recData = recData;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = true;
    }

    @Override
    public String toString() {
        return "SickLeaveRecommendation{" +
                "recommendationId=" + recommendationId +
                ", doctor=" + doctor +
                ", recData='" + recData + '\'' +
                ", isApproved=" + isApproved;
    }
}
