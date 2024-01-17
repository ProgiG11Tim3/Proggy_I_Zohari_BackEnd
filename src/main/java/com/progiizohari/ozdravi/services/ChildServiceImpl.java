package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.repositories.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildServiceImpl implements ChildService{

    @Autowired
    private ChildRepository repository;

    @Override
    public String getChildByOIB(String oib) {
        return repository.findByOIB(oib).toString();
    }

}
