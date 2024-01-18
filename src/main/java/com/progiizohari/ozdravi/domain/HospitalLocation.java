package com.progiizohari.ozdravi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Set;

@Entity
public class HospitalLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hospitalLocationId;

    @NotNull
    private String hospitalName;

    @NotNull
    private String location;

    @NotNull
    private String address;

    @NotNull
    private double x_coordinate;

    @NotNull
    private double y_coordinate;

    @ManyToMany
    @JoinTable(
            name = "examLocations",
            inverseJoinColumns = @JoinColumn(name = "examId", referencedColumnName = "examId"),
            joinColumns = @JoinColumn(name = "hospitalLocationId", referencedColumnName = "hospitalLocationId")
    )
    @JsonIgnore
    private List<SpecialistExamination> specialistExaminations;

    public HospitalLocation(String hospitalName, String location, String address, double x_coordinate, double y_coordinate) {
        this.hospitalName = hospitalName;
        this.location = location;
        this.address = address;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    public HospitalLocation() {

    }

    public int getHospitalLocationId() {
        return hospitalLocationId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public double getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(double y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public List<SpecialistExamination> getSpecialistExaminations() {
        return specialistExaminations;
    }

    public void setSpecialistExaminations(List<SpecialistExamination> specialistExaminations) {
        this.specialistExaminations = specialistExaminations;
    }

    @Override
    public String toString() {
        return "HospitalLocation{" +
                "hospitalLocationId=" + hospitalLocationId +
                ", hospitalName='" + hospitalName + '\'' +
                ", location='" + location + '\'' +
                ", address='" + address + '\'' +
                ", x_coordinate=" + x_coordinate +
                ", y_coordinate=" + y_coordinate +
                ", specialistExaminations=" + specialistExaminations +
                '}';
    }
}
