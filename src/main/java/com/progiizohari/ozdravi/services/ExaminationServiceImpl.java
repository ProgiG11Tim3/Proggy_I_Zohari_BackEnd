package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Examination;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.repositories.ExaminationRepository;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ExaminationRepository repository;

    @Autowired
    private LoginSessionHandler loginSessionHandler;

    @Override
    public String add(Examination examination) {
        repository.save(examination);
        return examination.toString() + " successfully added!";
    }

    @Override
    public List<Examination> getAllExaminations() {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        if(!loginSessionHandler.isUserLoggedIn(sessionID)){
            return null;
        }
        return repository.findAll();
    }
}
