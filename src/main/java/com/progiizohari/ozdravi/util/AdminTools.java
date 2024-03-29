package com.progiizohari.ozdravi.util;

import com.progiizohari.ozdravi.domain.Doctor;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.domain.Pediatrician;
import com.progiizohari.ozdravi.services.DoctorService;
import com.progiizohari.ozdravi.services.ParentService;
import com.progiizohari.ozdravi.services.PediatricianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminTools {

    @Autowired
    private Argon2Crypting argon_2_crypting;
    @Autowired
    private ParentService parent_service;
    @Autowired
    private DoctorService doctor_service;
    @Autowired
    private PediatricianService pediatrician_service;

    // NOTE: uses unencrpyted password in parent function parameter
    public boolean createParent(Parent parent) {
        parent.setPasswordParent(argon_2_crypting.HashPassword(parent.getPasswordParent()));
        return parent_service.add(parent) != "Trying to add Parent that already exists!";
    }

    // NOTE: uses unencrpyted password in doctor function parameter
    public boolean createDoctor(Doctor doctor) {
        doctor.setPasswordDoctor(argon_2_crypting.HashPassword(doctor.getPasswordDoctor()));
        return doctor_service.add(doctor) != "Trying to add Doctor that already exists!";
    }

    // NOTE: uses unencrpyted password in pediatrician function parameter
    public boolean createPediatrician(Pediatrician pediatrician) {
        pediatrician.setPasswordPediatrician(argon_2_crypting.HashPassword(pediatrician.getPasswordPediatrician()));
        return pediatrician_service.add(pediatrician) != "Trying to add Pediatrician that already exists!";
    }

    public boolean deleteParent(int id) {
        return parent_service.remove(id);
    }

    public boolean deleteDoctor(int id) {
        return doctor_service.remove(id);
    }

    public boolean deletePediatrician(int id) {
        return pediatrician_service.remove(id);
    }

    public boolean editParent(int id, Parent newParentData) {
        return parent_service.edit(id, newParentData);
    }

    public boolean editDoctor(int id, Doctor newDoctorData) {
        return doctor_service.edit(id, newDoctorData);
    }

    public boolean editPediatrician(int id, Pediatrician newPediatricianData) {
        return pediatrician_service.edit(id, newPediatricianData);
    }

    public Parent getParentById(int id) {
        for (Parent parent : parent_service.getAll())
        {
            if (parent.getParentId() == id)
            {
                return parent;
            }
        }
        return null;
    }

    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctor_service.getAll())
        {
            if (doctor.getDoctorId() == id)
            {
                return doctor;
            }
        }
        return null;
    }

    public Pediatrician getPediatricianById(int id) {
        for (Pediatrician pediatrician : pediatrician_service.getAll())
        {
            if (pediatrician.getPediatricianId() == id)
            {
                return pediatrician;
            }
        }
        return null;
    }
}
