package com.progiizohari.ozdravi.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/hello")
public class HelloController {
    
    @GetMapping
    public ResponseEntity<Object> home() {
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/hello")
                .build()
                .toUri();
        return ResponseEntity.status(303).location(uri).build();
    }
}
