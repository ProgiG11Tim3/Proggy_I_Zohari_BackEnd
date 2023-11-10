package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    public String add(Doctor doctor);
    public List<Doctor> getAll();
    public Optional<Doctor> getById(int Id);
}