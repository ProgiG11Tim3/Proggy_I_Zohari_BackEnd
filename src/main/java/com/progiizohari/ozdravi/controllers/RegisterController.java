package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.repositories.DoctorRepository;
import com.progiizohari.ozdravi.repositories.ParentRepository;
import com.progiizohari.ozdravi.repositories.PediatricianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    private ParentRepository parent_repo;
    @Autowired
    private DoctorRepository doctor_repo;
    @Autowired
    private PediatricianRepository pediatrician_repo;


}
