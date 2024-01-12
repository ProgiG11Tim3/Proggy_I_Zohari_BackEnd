package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.repositories.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService{

    @Autowired
    private MedicalRecordRepository repository;
}
