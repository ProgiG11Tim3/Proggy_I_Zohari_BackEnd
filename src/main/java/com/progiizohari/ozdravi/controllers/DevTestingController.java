package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.services.*;
import com.progiizohari.ozdravi.util.AdminTools;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DevTestingController {

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


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTestByNumber() {
        return pediatrician_service.getAll().get(0).toJsonIDs();
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String getTestByNumber2() {
        return child_service.getAll().get(0).toString();
    }
}
