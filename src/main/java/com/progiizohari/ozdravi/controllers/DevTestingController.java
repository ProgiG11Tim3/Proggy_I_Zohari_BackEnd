package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.services.ChildService;
import com.progiizohari.ozdravi.services.DoctorService;
import com.progiizohari.ozdravi.services.ParentService;
import com.progiizohari.ozdravi.services.PediatricianService;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DevTestingController {

    @Autowired
    private ParentService parentService;
    @Autowired
    private LoginSessionHandler loginSessionHandler;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PediatricianService pediatricianService;
    @Autowired
    private ChildService childService;


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTestByNumber() {
        return pediatricianService.getAll().get(0).toJsonIDs();
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String getTestByNumber2() {
        return childService.getAll().get(0).toString();
    }
}
