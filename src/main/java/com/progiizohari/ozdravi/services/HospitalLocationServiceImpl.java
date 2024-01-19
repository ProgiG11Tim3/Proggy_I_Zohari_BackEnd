package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.HospitalLocation;
import com.progiizohari.ozdravi.repositories.HospitalLocationRepository;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalLocationServiceImpl implements HospitalLocationService {

    @Autowired
    private HospitalLocationRepository hospitalLocationRepository;


    @Override
    public List<HospitalLocation> getAllHospitalLocations() {
        return hospitalLocationRepository.findAll();
    }
}
