package com.progiizohari.ozdravi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

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

    public SickLeaveRecommendation() {
    }

    public SickLeaveRecommendation(int recommendationId, Doctor doctor, String recData) {
        this.recommendationId = recommendationId;
        this.doctor = doctor;
        this.recData = recData;
    }

    public int getRecommendationId() {
        return recommendationId;
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
