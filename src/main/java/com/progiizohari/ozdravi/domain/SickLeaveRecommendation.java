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

    public SickLeaveRecommendation() {
    }

    public SickLeaveRecommendation(int recommendationId, Doctor doctor, String recData) {
        this.recommendationId = recommendationId;
        this.doctor = doctor;
        this.recData = recData;
        this.sickLeaveStartDate = new Date(System.currentTimeMillis());
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

    public void setRecommendationId(int recommendationId) {
        this.recommendationId = recommendationId;
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

    @Override
    public String toString() {
        return "SickLeaveRecommendation{" +
                "recommendationId=" + recommendationId +
                ", doctor=" + doctor +
                ", recData='" + recData + '\'' +
                '}';
    }
}
