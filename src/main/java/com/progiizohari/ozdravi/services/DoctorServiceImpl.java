package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Doctor;
import com.progiizohari.ozdravi.repositories.DoctorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private DoctorRepository repository;

    @Override
    public String add(Doctor doctor) {
        // check if doctor already exists
        for (Doctor entry : repository.findAll())
        {
            if (entry.equalVariables(doctor))
            {
                return "Trying to add Doctor that already exists!";
            }
        }

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

    @Override
    public boolean remove(Doctor doctor) {
        for (Doctor entry : repository.findAll())
        {
            if (entry.equalVariables(doctor))
            {
                repository.delete(doctor);
                entityManager.detach(doctor);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        for (Doctor entry : repository.findAll())
        {
            if (entry.getDoctorId() == id)
            {
                repository.delete(entry);
                entityManager.detach(entry);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean edit(int id, Doctor newDoctorData) {
        for (Doctor entry : repository.findAll())
        {
            if (entry.getDoctorId() == id)
            {
                entry.setNameDoctor(newDoctorData.getNameDoctor());
                entry.setLastNameDoctor(newDoctorData.getLastNameDoctor());
                entry.setEmailDoctor(newDoctorData.getEmailDoctor());
                entry.setParents(newDoctorData.getParents());
                entry.setDateOfBirthDoctor(newDoctorData.getDateOfBirthDoctor());
                entry.setPhoneNumberDoctor(newDoctorData.getPhoneNumberDoctor());
                entry.setUserNameDoctor(newDoctorData.getUserNameDoctor());
                entry.setPasswordDoctor(newDoctorData.getPasswordDoctor());
                repository.save(entry);
                return true;
            }
        }
        return false;
    }
}