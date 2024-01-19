package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Child;
import com.progiizohari.ozdravi.repositories.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService{

    @Autowired
    private ChildRepository repository;

    @Override
    public String getChildByOIB(String oib) {
        return repository.findByOIB(oib).toString();
    }

    @Override
    public List<Child> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean add(Child child) {
        for (Child entry : repository.findAll())
        {
            if (entry.getOIB().equals(child.getOIB()))
            {
                return false;
            }
        }
        repository.save(child);
        return true;
    }

    @Override
    public boolean remove(Child child) {
        for (Child entry : repository.findAll())
        {
            if (entry.getOIB().equals(child.getOIB()))
            {
                repository.delete(child);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean edit(int id, Child child) {
        for (Child entry : repository.findAll())
        {
            if (entry.getOIB().equals(child.getOIB()))
            {
                repository.save(child);
                return true;
            }
        }
        return false;
    }

}
