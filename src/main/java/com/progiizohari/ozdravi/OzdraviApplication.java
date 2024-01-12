package com.progiizohari.ozdravi;


import com.progiizohari.ozdravi.domain.Child;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
public class OzdraviApplication {

    public static void main(String[] args) {
        SpringApplication.run(OzdraviApplication.class, args);
    }

}