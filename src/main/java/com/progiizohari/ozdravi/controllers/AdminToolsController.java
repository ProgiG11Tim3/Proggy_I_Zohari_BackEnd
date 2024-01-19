package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.services.*;
import com.progiizohari.ozdravi.util.AdminTools;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class AdminToolsController {

    @Autowired
    private AdminTools admin_tools;
    @Autowired
    private ParentService parent_service;
    @Autowired
    private DoctorService doctor_service;
    @Autowired
    private PediatricianService pediatrician_service;
    @Autowired
    private ChildService child_service;
    @Autowired
    private EmailService email_service;
    @Autowired
    private NotificationService notification_service;
    @Autowired
    private SickNoteService sick_note_service;
    @Autowired
    private SpecialistExaminationService specialist_examination_service;
    @Autowired
    private SickLeaveService sick_leave_service;
    @Autowired
    private MedicalRecordService medical_record_service;
    @Autowired
    private MedicalReportService medical_report_service;
    @Autowired
    private LoginSessionHandler login_session_handler;
    @Autowired
    private ExaminationService examination_service;


    // UC 24
    @PostMapping("/admin/createPediatrician")
    public ResponseEntity<String> createPediatrician(@RequestBody CreatePediatrician createPediatrician) {
        Pediatrician pediatrician = new Pediatrician();
        pediatrician.setEmailPediatrician(createPediatrician.getEmailPediatrician());
        pediatrician.setNamePediatrician(createPediatrician.getNamePediatrician());
        pediatrician.setLastNamePediatrician(createPediatrician.getLastNamePediatrician());
        pediatrician.setUserNamePediatrician(createPediatrician.getUserNamePediatrician());
        pediatrician.setPasswordPediatrician(createPediatrician.getPasswordPediatrician());
        pediatrician.setPhoneNumberPediatrician(createPediatrician.getPhoneNumberPediatrician());
        pediatrician.setDateOfBirthPediatrician(createPediatrician.getDateOfBirthPediatrician());
        boolean success = admin_tools.createPediatrician(pediatrician);

        if (success) {
            return ResponseEntity.ok("Pedijatar uspješno kreiran!");
        } else {
            return ResponseEntity.badRequest().body("Pedijatar sa istim podatcima vec postoji!");
        }
    }

    // UC 24
    @PostMapping("/admin/createDoctor")
    public ResponseEntity<String> createDoctr(@RequestBody CreateDoctor createDoctor) {
        Doctor doctor = new Doctor();
        doctor.setEmailDoctor(createDoctor.getEmailDoctor());
        doctor.setNameDoctor(createDoctor.getNameDoctor());
        doctor.setLastNameDoctor(createDoctor.getLastNameDoctor());
        doctor.setUserNameDoctor(createDoctor.getUserNameDoctor());
        doctor.setPasswordDoctor(createDoctor.getPasswordDoctor());
        doctor.setPhoneNumberDoctor(createDoctor.getPhoneNumberDoctor());
        doctor.setDateOfBirthDoctor(createDoctor.getDateOfBirthDoctor());
        boolean success = admin_tools.createDoctor(doctor);

        if (success) {
            return ResponseEntity.ok("Doktor uspješno kreiran!");
        } else {
            return ResponseEntity.badRequest().body("Doktor sa istim podatcima vec postoji!");
        }
    }

    // UC 25
    @GetMapping("/admin/getAllParents")
    public ResponseEntity<List<AdminToolUserEntity>> getAllParents() {
        List<AdminToolUserEntity> return_list = new ArrayList<>();

        List<Parent> parents = parent_service.getAll();
        for (Parent parent : parents) {
            AdminToolUserEntity string_with_link = new AdminToolUserEntity();
            string_with_link.setUserJson(parent.toJsonIDs());
            string_with_link.setData_link("/admin/getParent/" + parent.getParentId());
            string_with_link.setDelete_link("/admin/deleteParent/" + parent.getParentId());
            string_with_link.setEdit_link("/admin/editParent/" + parent.getParentId());
            string_with_link.setUser_id(parent.getParentId());
            return_list.add(string_with_link);
        }

        return ResponseEntity.ok(return_list);
    }

    // UC 25
    @GetMapping("/admin/getAllDoctors")
    public ResponseEntity<List<AdminToolUserEntity>> getAllDoctors() {
        List<AdminToolUserEntity> return_list = new ArrayList<>();

        List<Doctor> doctors = doctor_service.getAll();
        for (Doctor doctor : doctors) {
            AdminToolUserEntity string_with_link = new AdminToolUserEntity();
            string_with_link.setUserJson(doctor.toJsonIDs());
            string_with_link.setData_link("/admin/getDoctor/" + doctor.getDoctorId());
            string_with_link.setDelete_link("/admin/deleteDoctor/" + doctor.getDoctorId());
            string_with_link.setEdit_link("/admin/editDoctor/" + doctor.getDoctorId());
            string_with_link.setUser_id(doctor.getDoctorId());
            return_list.add(string_with_link);
        }

        return ResponseEntity.ok(return_list);
    }

    // UC 25
    @GetMapping("/admin/getAllPediatricians")
    public ResponseEntity<List<AdminToolUserEntity>> getAllPediatricians() {
        List<AdminToolUserEntity> return_list = new ArrayList<>();

        List<Pediatrician> pediatricians = pediatrician_service.getAll();
        for (Pediatrician pediatrician : pediatricians) {
            AdminToolUserEntity string_with_link = new AdminToolUserEntity();
            string_with_link.setUserJson(pediatrician.toJsonIDs());
            string_with_link.setData_link("/admin/getPediatrician/" + pediatrician.getPediatricianId());
            string_with_link.setDelete_link("/admin/deletePediatrician/" + pediatrician.getPediatricianId());
            string_with_link.setEdit_link("/admin/editPediatrician/" + pediatrician.getPediatricianId());
            string_with_link.setUser_id(pediatrician.getPediatricianId());
            return_list.add(string_with_link);
        }

        return ResponseEntity.ok(return_list);
    }

    // UC 25
    @GetMapping("/admin/getAllPeople")
    public ResponseEntity<List<AdminToolUserEntity>> getAllPeople() {
        List<AdminToolUserEntity> return_list = new ArrayList<>();

        for (Parent parent : parent_service.getAll()) {
            AdminToolUserEntity string_with_link = new AdminToolUserEntity();
            string_with_link.setUserJson(parent.toJsonIDs());
            string_with_link.setData_link("/admin/getParent/" + parent.getParentId());
            string_with_link.setDelete_link("/admin/deleteParent/" + parent.getParentId());
            string_with_link.setEdit_link("/admin/editParent/" + parent.getParentId());
            string_with_link.setUser_id(parent.getParentId());
            return_list.add(string_with_link);
        }

        for (Doctor doctor : doctor_service.getAll()) {
            AdminToolUserEntity string_with_link = new AdminToolUserEntity();
            string_with_link.setUserJson(doctor.toJsonIDs());
            string_with_link.setData_link("/admin/getDoctor/" + doctor.getDoctorId());
            string_with_link.setDelete_link("/admin/deleteDoctor/" + doctor.getDoctorId());
            string_with_link.setEdit_link("/admin/editDoctor/" + doctor.getDoctorId());
            string_with_link.setUser_id(doctor.getDoctorId());
            return_list.add(string_with_link);
        }

        for (Pediatrician pediatrician : pediatrician_service.getAll()) {
            AdminToolUserEntity string_with_link = new AdminToolUserEntity();
            string_with_link.setUserJson(pediatrician.toJsonIDs());
            string_with_link.setData_link("/admin/getPediatrician/" + pediatrician.getPediatricianId());
            string_with_link.setDelete_link("/admin/deletePediatrician/" + pediatrician.getPediatricianId());
            string_with_link.setEdit_link("/admin/editPediatrician/" + pediatrician.getPediatricianId());
            string_with_link.setUser_id(pediatrician.getPediatricianId());
            return_list.add(string_with_link);
        }

        return ResponseEntity.ok(return_list);
    }

    // UC 26
    @GetMapping("/admin/getParent/{id}")
    public ResponseEntity<String> getParent(@PathVariable int id) {
        Parent parent = null;
        for (Parent entry : parent_service.getAll())
        {
            if (entry.getParentId() == id)
            {
                parent = entry;
            }
        }
        if (parent == null) {
            return ResponseEntity.badRequest().body("Parent not found by id: " + id + "!");
        }

        return ResponseEntity.ok(parent.toJsonIDs());
    }

    // UC 26
    @GetMapping("/admin/getDoctor/{id}")
    public ResponseEntity<String> getDoctor(@PathVariable int id) {
        Doctor doctor = null;
        for (Doctor entry : doctor_service.getAll())
        {
            if (entry.getDoctorId() == id)
            {
                doctor = entry;
            }
        }
        if (doctor == null) {
            return ResponseEntity.badRequest().body("Doctor not found by id: " + id + "!");
        }

        return ResponseEntity.ok(doctor.toJsonIDs());
    }

    // UC 26
    @GetMapping("/admin/getPediatrician/{id}")
    public ResponseEntity<String> getPediatrician(@PathVariable int id) {
        Pediatrician pediatrician = null;
        for (Pediatrician entry : pediatrician_service.getAll())
        {
            if (entry.getPediatricianId() == id)
            {
                pediatrician = entry;
            }
        }
        if (pediatrician == null) {
            return ResponseEntity.badRequest().body("Pediatrician not found by id: " + id + "!");
        }

        return ResponseEntity.ok(pediatrician.toJsonIDs());
    }

    // UC 27
    @PostMapping("/admin/deleteParent/{id}")
    public ResponseEntity<String> deleteParent(@PathVariable int id) {
        Parent parent = null;
        for (Parent entry : parent_service.getAll())
        {
            if (entry.getParentId() == id)
            {
                parent = entry;
            }
        }
        if (parent == null) {
            return ResponseEntity.badRequest().body("Parent not found by id: " + id + "!");
        }

        parent_service.remove(parent);
        return ResponseEntity.ok("OK");
    }

    // UC 27
    @PostMapping("/admin/deleteDoctor/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int id) {
        Doctor doctor = null;
        for (Doctor entry : doctor_service.getAll())
        {
            if (entry.getDoctorId() == id)
            {
                doctor = entry;
            }
        }
        if (doctor == null) {
            return ResponseEntity.badRequest().body("Doctor not found by id: " + id + "!");
        }

        doctor_service.remove(doctor);
        return ResponseEntity.ok("OK");
    }

    // UC 27
    @PostMapping("/admin/deletePediatrician/{id}")
    public ResponseEntity<String> deletePediatrician(@PathVariable int id) {
        Pediatrician pediatrician = null;
        for (Pediatrician entry : pediatrician_service.getAll())
        {
            if (entry.getPediatricianId() == id)
            {
                pediatrician = entry;
            }
        }
        if (pediatrician == null) {
            return ResponseEntity.badRequest().body("Pediatrician not found by id: " + id + "!");
        }

        pediatrician_service.remove(pediatrician);
        return ResponseEntity.ok("OK");
    }

    // UC 28
    @PostMapping("/admin/editParent/{id}")
    public ResponseEntity<String> editParent(@PathVariable int id, @RequestBody Parent newParentData) {
        Parent parent = null;
        for (Parent entry : parent_service.getAll())
        {
            if (entry.getParentId() == id)
            {
                parent = entry;
            }
        }
        if (parent == null) {
            return ResponseEntity.badRequest().body("Parent not found by id: " + id + "!");
        }

        parent_service.edit(id, newParentData);
        return ResponseEntity.ok("OK");
    }

    // UC 28
    @PostMapping("/admin/editDoctor/{id}")
    public ResponseEntity<String> editDoctor(@PathVariable int id, @RequestBody Doctor newDoctorData) {
        Doctor doctor = null;
        for (Doctor entry : doctor_service.getAll())
        {
            if (entry.getDoctorId() == id)
            {
                doctor = entry;
            }
        }
        if (doctor == null) {
            return ResponseEntity.badRequest().body("Doctor not found by id: " + id + "!");
        }

        doctor_service.edit(id, newDoctorData);
        return ResponseEntity.ok("OK");
    }

    // UC 28
    @PostMapping("/admin/editPediatrician/{id}")
    public ResponseEntity<String> editPediatrician(@PathVariable int id, @RequestBody Pediatrician newPediatricianData) {
        Pediatrician pediatrician = null;
        for (Pediatrician entry : pediatrician_service.getAll())
        {
            if (entry.getPediatricianId() == id)
            {
                pediatrician = entry;
            }
        }
        if (pediatrician == null) {
            return ResponseEntity.badRequest().body("Pediatrician not found by id: " + id + "!");
        }

        pediatrician_service.edit(id, newPediatricianData);
        return ResponseEntity.ok("OK");
    }
}
