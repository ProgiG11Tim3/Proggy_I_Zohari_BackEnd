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
    @JoinColumn(name = "parentId")
    private Parent parent;

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

    public SickLeaveRecommendation(Parent parent, String recData, String employerEmail) {
        this.parent = parent;
        this.recData = recData;
        this.employerEmail = employerEmail;
        this.sickLeaveStartDate = new Date(System.currentTimeMillis());
        this.isApproved = false;
    }

    public int getRecommendationId() {
        return recommendationId;
    }

    public String getEmployerEmail() {
        return employerEmail;
    }

    public void setEmployerEmail(String employerEmail) {
        this.employerEmail = employerEmail;
    }

    public Date getSickLeaveStartDate() {
        return sickLeaveStartDate;
    }

    public int daysSinceSickLeaveStartDate() {
        return (int) ((System.currentTimeMillis() - sickLeaveStartDate.getTime()) / (1000 * 60 * 60 * 24));
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
        isApproved = approved;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void setSickLeaveStartDate(Date sickLeaveStartDate) {
        this.sickLeaveStartDate = sickLeaveStartDate;
    }

    @Override
    public String toString() {
        return "SickLeaveRecommendation{" +
                "recommendationId=" + recommendationId +
                ", recData='" + recData + '\'' +
                ", isApproved=" + isApproved;
    }

    public String toJsonIDs() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{")
                .append("\"recommendationId\":").append(recommendationId)
                .append(", \"parentOIB\":").append(parent.getOIB())
                .append(", \"recData\":\"").append(recData).append("\"")
                .append(", \"sickLeaveStartDate\":\"").append(sickLeaveStartDate).append("\"")
                .append(", \"employerEmail\":\"").append(employerEmail).append("\"")
                .append(", \"isApproved\":").append(isApproved)
                .append("}");

        return jsonBuilder.toString();
    }
}
