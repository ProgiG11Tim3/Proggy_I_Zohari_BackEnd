package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.SickLeaveRecommendation;
import com.progiizohari.ozdravi.repositories.SickLeaveRecommendationRepository;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SickLeaveServiceImpl implements SickLeaveService{

    @Autowired
    private SickLeaveRecommendationRepository sickLeaveRepository;

    @Override
    public String add(SickLeaveRecommendation sickLeave) {
        sickLeaveRepository.save(sickLeave);
        return sickLeave.toString() + " successfully added!";
    }
}
