package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Pediatrician;
import com.progiizohari.ozdravi.repositories.PediatricianRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PediatricianServiceImpl implements PediatricianService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private PediatricianRepository repository;
    @Override
    public String add(Pediatrician pediatrician) {
        // check if pediatrician already exists
        for (Pediatrician entry : repository.findAll())
        {
            if (entry.equalVariables(pediatrician))
            {
                return "Trying to add Pediatrician that already exists!";
            }
        }

        repository.save(pediatrician);
        return "Pediatrician " + pediatrician.getNamePediatrician() + " " + pediatrician.getLastNamePediatrician() + " successfully added!";
    }

    @Override
    public List<Pediatrician> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Pediatrician> getById(int Id) {
        return repository.findById(Id);
    }

    @Override
    public boolean remove(Pediatrician pediatrician) {
        for (Pediatrician entry : repository.findAll())
        {
            if (entry.equalVariables(pediatrician))
            {
                repository.delete(pediatrician);
                entityManager.detach(pediatrician);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        for (Pediatrician entry : repository.findAll())
        {
            if (entry.getPediatricianId() == id)
            {
                repository.delete(entry);
                entityManager.detach(entry);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean edit(int id, Pediatrician newPediatricianData) {
        for (Pediatrician entry : repository.findAll())
        {
            if (entry.getPediatricianId() == id)
            {
                entry.setNamePediatrician(newPediatricianData.getNamePediatrician());
                entry.setLastNamePediatrician(newPediatricianData.getLastNamePediatrician());
                entry.setPasswordPediatrician(newPediatricianData.getPasswordPediatrician());
                entry.setChildren(newPediatricianData.getChildren());
                entry.setNamePediatrician(newPediatricianData.getNamePediatrician());
                entry.setEmailPediatrician(newPediatricianData.getEmailPediatrician());
                entry.setPhoneNumberPediatrician(newPediatricianData.getPhoneNumberPediatrician());
                entry.setDateOfBirthPediatrician(newPediatricianData.getDateOfBirthPediatrician());
                repository.save(entry);
                return true;
            }
        }
        return false;
    }
}