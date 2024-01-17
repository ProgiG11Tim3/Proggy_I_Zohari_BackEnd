package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.ParentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentRepository repository;

    @Override
    public String add(Parent parent) {

        if (getByOIB(parent.getOIB()) != null)
        {
            return "Trying to add Parent that already exists!";
        }
        if (parent.getOIB().length() != 11){
            return "Ne dozvoljeni OIB!";
        }

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

    @Override
    public boolean remove(Parent parent) {
        for (Parent entry : repository.findAll())
        {
            if (entry.equalVariables(parent))
            {
                repository.delete(parent);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        for (Parent entry : repository.findAll())
        {
            if (entry.getParentId() == id)
            {
                repository.delete(entry);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean edit(int id, Parent newParentData) {
        for (Parent entry : repository.findAll())
        {
            if (entry.getParentId() == id)
            {
                entry.setOIB(newParentData.getOIB());
                entry.setNameParent(newParentData.getNameParent());
                entry.setLastNameParent(newParentData.getLastNameParent());
                entry.setDateOfBirthParent(newParentData.getDateOfBirthParent());
                entry.setUserNameParent(newParentData.getUserNameParent());
                entry.setPasswordParent(newParentData.getPasswordParent());
                entry.setPhoneNumberParent(newParentData.getPhoneNumberParent());
                entry.setEmailParent(newParentData.getEmailParent());
                entry.setPostalCode(newParentData.getPostalCode());
                entry.setPlaceOfResidence(newParentData.getPlaceOfResidence());
                entry.setEmployerEmail(newParentData.getEmployerEmail());
                entry.setDoctor(newParentData.getDoctor());
                entry.setChildren(newParentData.getChildren());
                repository.save(entry);
                return true;
            }
        }
        return false;
    }
}