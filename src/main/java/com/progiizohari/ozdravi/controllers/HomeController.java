package com.progiizohari.ozdravi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {
    
    @GetMapping
    public String home() {
        return "index";
    }
}
