package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.SickLeaveRecommendation;
import com.progiizohari.ozdravi.repositories.SickLeaveRecommendationRepository;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SickLeaveServiceImpl implements SickLeaveService{

    @Autowired
    private SickLeaveRecommendationRepository sickLeaveRepository;

    @Override
    public String add(SickLeaveRecommendation sickLeave) {
        sickLeaveRepository.save(sickLeave);
        return sickLeave.toString() + " successfully added!";
    }

    @Override
    public List<SickLeaveRecommendation> getAll() {
        return sickLeaveRepository.findAll();
    }

    @Override
    public String approve(int id) {
        Optional<SickLeaveRecommendation> optionalSickLeave = sickLeaveRepository.findById(id);
        if (optionalSickLeave.isPresent()) {
            SickLeaveRecommendation sickLeave = optionalSickLeave.get();
            sickLeave.setApproved(true);
            sickLeaveRepository.save(sickLeave);
            return "Sick leave approved";
        } else {
            return "Sick leave not found";
        }
    }

    @Override
    public List<SickLeaveRecommendation> getUnapproved() {
        return sickLeaveRepository.findByIsApproved(false);
    }
}
