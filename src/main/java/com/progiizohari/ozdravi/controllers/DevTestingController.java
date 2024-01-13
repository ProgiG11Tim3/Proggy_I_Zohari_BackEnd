package com.progiizohari.ozdravi.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class DevTestingController {

    @RequestMapping(value = "/test{number:[1-9]}", method = RequestMethod.GET)
    public String getTestByNumber(@PathVariable String number) {
        return "Test " + number;
    }
}
