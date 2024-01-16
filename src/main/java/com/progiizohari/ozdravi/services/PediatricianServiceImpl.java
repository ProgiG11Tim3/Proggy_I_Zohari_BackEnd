package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.repositories.ChildRepository;
import com.progiizohari.ozdravi.repositories.MedicalRecordRepository;
import com.progiizohari.ozdravi.repositories.PediatricianRepository;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PediatricianServiceImpl implements PediatricianService {

    @Autowired
    private PediatricianRepository pediatricianRepository;
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    @Autowired
    private LoginSessionHandler loginSessionHandler;

    @Override
    public String add(Pediatrician pediatrician) {
        // check if pediatrician already exists
        for (Pediatrician entry : pediatricianRepository.findAll())
        {
            if (entry.equalVariables(pediatrician))
            {
                return "Trying to add Pediatrician that already exists!";
            }
        }

        pediatricianRepository.save(pediatrician);
        return "Pediatrician " + pediatrician.getNamePediatrician() + " " + pediatrician.getLastNamePediatrician() + " successfully added!";
    }

    @Override
    public List<Pediatrician> getAll() {
        return pediatricianRepository.findAll();
    }

    @Override
    public Optional<Pediatrician> getById(int Id) {
        return pediatricianRepository.findById(Id);
    }

    @Override
    public boolean remove(Pediatrician pediatrician) {
        for (Pediatrician entry : pediatricianRepository.findAll())
        {
            if (entry.equalVariables(pediatrician))
            {
                pediatricianRepository.delete(pediatrician);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        for (Pediatrician entry : pediatricianRepository.findAll())
        {
            if (entry.getPediatricianId() == id)
            {
                pediatricianRepository.delete(entry);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean edit(int id, Pediatrician newPediatricianData) {
        for (Pediatrician entry : pediatricianRepository.findAll())
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
                pediatricianRepository.save(entry);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Child> getAllPatients() {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Pediatrician pediatrician = loginSessionHandler.getPediatrician(sessionID);

        if(pediatrician == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        return pediatrician.getChildren();
    }

    @Override
    public Child getPatientByOIB(String OIB) {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Pediatrician pediatrician = loginSessionHandler.getPediatrician(sessionID);

        if(pediatrician == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        Child child = childRepository.findByOIB(OIB);

        if(!pediatrician.getChildren().contains(child)){
            System.out.println("Nije tvoj pacijent!");
            return null;
        }
        return child;
    }

    @Override
    public MedicalRecord getPatientRecord(String OIB) {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Pediatrician pediatrician = loginSessionHandler.getPediatrician(sessionID);

        if(pediatrician == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        Child child = childRepository.findByOIB(OIB);

        if(!pediatrician.getChildren().contains(child)){
            System.out.println("Nije tvoj pacijent!");
            return null;
        }

        MedicalRecord medicalRecord = medicalRecordRepository.findByChild_OIB(OIB);

        if(medicalRecord == null){
            MedicalRecord med = new MedicalRecord(child);
            medicalRecordRepository.save(med);
            return med;
        }
        return medicalRecord;
    }

    @Override
    public List<MedicalReport> getPatientReports(String OIB) {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Pediatrician pediatrician = loginSessionHandler.getPediatrician(sessionID);

        if(pediatrician == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        Child child = childRepository.findByOIB(OIB);

        if(!pediatrician.getChildren().contains(child)){
            System.out.println("Nije tvoj pacijent!");
            return null;
        }

        MedicalRecord medicalRecord = medicalRecordRepository.findByChild_OIB(OIB);

        if(medicalRecord == null){
            MedicalRecord med = new MedicalRecord(child);
            medicalRecordRepository.save(med);
            medicalRecord = med;
        }
        return medicalRecord.getMedicalReports();
    }
}