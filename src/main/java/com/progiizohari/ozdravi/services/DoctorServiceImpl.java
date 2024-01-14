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
            System.out.println("Nemas pristup!");
            return null;
        }

        return doctor.getParents();
    }

    @Override
    public Parent getPatientByOIB(String OIB) {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Doctor doctor = loginSessionHandler.getDoctor(sessionID);

        if(doctor == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        Parent parent = parentRepository.findByOIB(OIB);

        if(!doctor.getParents().contains(parent)){
            System.out.println("Nije tvoj pacijent!");
            return null;
        }
        return parent;
    }

    @Override
    public MedicalRecord getPatientRecord(String OIB) {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Doctor doctor = loginSessionHandler.getDoctor(sessionID);

        if(doctor == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        Parent parent = parentRepository.findByOIB(OIB);

        if(!doctor.getParents().contains(parent)){
            System.out.println("Nije tvoj pacijent!");
            return null;
        }

        MedicalRecord medicalRecord = medicalRecordRepository.findByParent_OIB(OIB);

        if(medicalRecord == null){
            return new MedicalRecord(parent);
        }
        return medicalRecord;
    }

    @Override
    public List<MedicalReport> getPatientReports(String OIB) {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Doctor doctor = loginSessionHandler.getDoctor(sessionID);

        if(doctor == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        Parent parent = parentRepository.findByOIB(OIB);

        if(!doctor.getParents().contains(parent)){
            System.out.println("Nije tvoj pacijent!");
            return null;
        }

        MedicalRecord medicalRecord = medicalRecordRepository.findByParent_OIB(OIB);

        if(medicalRecord.getMedicalReports() == null){
            return new ArrayList<>();
        }
        return medicalRecord.getMedicalReports();
    }
}