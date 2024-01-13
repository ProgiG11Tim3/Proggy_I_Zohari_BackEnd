package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Doctor;
import com.progiizohari.ozdravi.domain.LoginSession;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    public String add(Doctor doctor);
    public List<Doctor> getAll();
    public Optional<Doctor> getById(int Id);
    public boolean remove(Doctor doctor);
    public boolean remove(int id);
    public boolean edit(int id, Doctor newDoctorData);
}