package com.progiizohari.ozdravi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OzdraviApplication {

    public static void main(String[] args) {
        SpringApplication.run(OzdraviApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return ("This is Ozdravi web app");
    }
}
