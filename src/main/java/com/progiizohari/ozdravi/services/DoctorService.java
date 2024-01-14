package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    public String add(Doctor doctor);
    public List<Doctor> getAll();
    public Optional<Doctor> getById(int Id);
    public boolean remove(Doctor doctor);
    public boolean remove(int id);
    public boolean edit(int id, Doctor newDoctorData);
    //UC12
    public List<Parent> getAllPatients();
    //UC13
    public Parent getPatientByOIB(String OIB);
    //UC14
    public MedicalRecord getPatientRecord(String OIB);
    //UC20
    public List<MedicalReport> getPatientReports(String OIB);
}