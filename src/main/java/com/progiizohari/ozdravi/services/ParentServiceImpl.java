package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ParentServiceImpl implements ParentService{

    @Autowired
    private ParentRepository repository;


    //primjer Parenta u repozitoriju za testiranje
    Parent testParent = new Parent(1, "oib12345678", "imeRoditelja",
            "prezimeRoditelja", LocalDate.of(2023, 11, 7),
            "userNameRoditelja", "passwordRoditelja", "brojMobitelaRoditelja",
            "emailRoditelja@gmail.com", 10000, "Zagreb", "emailPoslodavca@gmail.com",
            null, null);

    @Override
    public String add(Parent parent) {
        repository.save(parent);
        return "Parent " + parent.getNameParent() + " " + parent.getLastNameParent() + " successfully added!";
    }

    @Override
    public List<Parent> getAll() {
        return repository.findAll();
    }

    @Override
    public Parent getByOIB(String OIB) {
        return repository.findByOIB(OIB);
    }
}
