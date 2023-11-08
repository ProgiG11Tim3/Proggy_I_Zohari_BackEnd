package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Doctor;
import com.progiizohari.ozdravi.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository repository;

    @Override
    public String add(Doctor doctor) {
        repository.save(doctor);
        return "Doctor " + doctor.getNameDoctor() + " " + doctor.getLastNameDoctor() + " successfully added!";
    }

    @Override
    public List<Doctor> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Doctor> getById(int Id) {
        return repository.findById(Id);
    }
}
