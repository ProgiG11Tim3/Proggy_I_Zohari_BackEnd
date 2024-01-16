package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Doctor;
import com.progiizohari.ozdravi.domain.MedicalRecord;
import com.progiizohari.ozdravi.domain.MedicalReport;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.DoctorRepository;
import com.progiizohari.ozdravi.repositories.MedicalRecordRepository;
import com.progiizohari.ozdravi.repositories.ParentRepository;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    @Autowired
    private LoginSessionHandler loginSessionHandler;

    @Override
    public String add(Doctor doctor) {
        // check if doctor already exists
        for (Doctor entry : doctorRepository.findAll())
        {
            if (entry.equalVariables(doctor))
            {
                return "Trying to add Doctor that already exists!";
            }
        }

        doctorRepository.save(doctor);
        return "Doctor " + doctor.getNameDoctor() + " " + doctor.getLastNameDoctor() + " successfully added!";
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> getById(int Id) {
        return doctorRepository.findById(Id);
    }

    @Override
    public boolean remove(Doctor doctor) {
        for (Doctor entry : doctorRepository.findAll())
        {
            if (entry.equalVariables(doctor))
            {
                doctorRepository.delete(doctor);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        for (Doctor entry : doctorRepository.findAll())
        {
            if (entry.getDoctorId() == id)
            {
                doctorRepository.delete(entry);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean edit(int id, Doctor newDoctorData) {
        for (Doctor entry : doctorRepository.findAll())
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
                entry.setSickLeaveRecommendations(newDoctorData.getSickLeaveRecommendations());
                doctorRepository.save(entry);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Parent> getAllPatients() {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Doctor doctor = loginSessionHandler.getDoctor(sessionID);

        if(doctor == null) {
            System.out.println("Nemaš pristup!");
            return null;
        }
        System.out.println("Svi pacijenti poslani na frontend!");
        return doctor.getParents();
    }

    @Override
    public Parent getPatientByOIB(String OIB) {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Doctor doctor = loginSessionHandler.getDoctor(sessionID);

        if(doctor == null) {
            System.out.println("Nemaš pristup!");
            return null;
        }

        Parent parent = parentRepository.findByOIB(OIB);

        if(parent == null){
            System.out.println("Nepostojeći OIB!");
            return null;
        }

        if(!doctor.getParents().contains(parent)){
            System.out.println("Nije tvoj pacijent!");
            return null;
        }
        System.out.println("Pacijent poslan na frontend!");
        return parent;
    }

    @Override
    public MedicalRecord getPatientRecord(String OIB) {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Doctor doctor = loginSessionHandler.getDoctor(sessionID);

        if(doctor == null) {
            System.out.println("Nemaš pristup!");
            return null;
        }

        Parent parent = parentRepository.findByOIB(OIB);

        if(parent == null){
            System.out.println("Nepostojeći OIB!");
            return null;
        }

        if(!doctor.getParents().contains(parent)){
            System.out.println("Nije tvoj pacijent!");
            return null;
        }

        MedicalRecord medicalRecord = medicalRecordRepository.findByParent_OIB(OIB);

        if(medicalRecord == null){
            MedicalRecord med = new MedicalRecord(parent);
            medicalRecordRepository.save(med);
            System.out.println("Pacijent još nema karton. Stvoren prazan karton pacijenta i poslan na frontend!");
            return med;
        }
        System.out.println("Karton pacijenta poslan na frontend!");
        return medicalRecord;
    }

    @Override
    public List<MedicalReport> getPatientReports(String OIB) {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Doctor doctor = loginSessionHandler.getDoctor(sessionID);

        if(doctor == null) {
            System.out.println("Nemaš pristup!");
            return null;
        }

        Parent parent = parentRepository.findByOIB(OIB);

        if(parent == null){
            System.out.println("Nepostojeći OIB!");
            return null;
        }

        if(!doctor.getParents().contains(parent)){
            System.out.println("Nije tvoj pacijent!");
            return null;
        }

        MedicalRecord medicalRecord = medicalRecordRepository.findByParent_OIB(OIB);

        if(medicalRecord == null){
            MedicalRecord med = new MedicalRecord(parent);
            medicalRecordRepository.save(med);
            medicalRecord = med;
            System.out.println("Pacijent još nema karton. Stvoren prazan karton pacijenta.");
        }

        if(medicalRecord.getMedicalReports() == null){
            System.out.println("Prazna lista nalaza poslana na frontend!");
            return new ArrayList<>();
        }
        System.out.println("Lista nalaza poslana na frontend!");
        return medicalRecord.getMedicalReports();
    }
}