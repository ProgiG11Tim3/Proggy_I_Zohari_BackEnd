package com.progiizohari.ozdravi;

import com.progiizohari.ozdravi.domain.LoginRequest;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@SpringBootApplication
@RestController
public class OzdraviApplication {
    //private static final Logger log = LoggerFactory.getLogger(OzdraviApplication.class);
    
    @Autowired
    private ParentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(OzdraviApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner demo() {
        return (args) -> {
            Parent testParent = new Parent(1, "12345678910", "imeRoditelja",
                    "prezimeRoditelja", LocalDate.of(2023, 11, 7),
                    "userNameRoditelja", "passwordRoditelja", "brojMobitelaRoditelja",
                    "emailRoditelja@gmail.com", 10000, "Zagreb", "emailPoslodavca@gmail.com",
                    null, null);
            repository.save(testParent);

            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(Parent -> {
                log.info(testParent.toString());
            });
            log.info("");
        };
    }*/

    @GetMapping("/")
    public String MainPage() {
        return "MainPage";
    }
}
