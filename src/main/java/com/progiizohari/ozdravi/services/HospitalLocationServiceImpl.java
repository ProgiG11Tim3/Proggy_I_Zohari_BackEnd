package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.repositories.HospitalLocationRepository;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalLocationServiceImpl implements HospitalLocationService {

    @Autowired
    private HospitalLocationRepository hospitalLocationRepository;

    @Autowired
    private LoginSessionHandler loginSessionHandler;


}
