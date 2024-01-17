package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.services.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChildController {

    @Autowired
    private ChildService service;

    @GetMapping("/getChildByOIB{oib}")
    public String getChildByOIB(String oib) {
        if (oib == null) {
            return "OIB is null";
        }

        if (oib.length() != 11) {
            return "OIB is not 11 characters long";
        }

        if (!oib.matches("[0-9]+")) {
            return "OIB contains non-numeric characters";
        }

        return service.getChildByOIB(oib);
    }
}
