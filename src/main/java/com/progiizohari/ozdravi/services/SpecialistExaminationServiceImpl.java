package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Child;
import com.progiizohari.ozdravi.domain.MedicalRecord;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.domain.SpecialistExamination;
import com.progiizohari.ozdravi.repositories.SpecialistExaminationRepository;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

@Service
public class SpecialistExaminationServiceImpl implements SpecialistExaminationService{

    @Autowired
    private SpecialistExaminationRepository repository;

    @Autowired
    private LoginSessionHandler loginSessionHandler;


    @Override
    public List<SpecialistExamination> getParentSpecialistExaminations() {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Parent parent = loginSessionHandler.getParent(sessionID);

        if(parent == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        MedicalRecord medicalRecord = parent.getMedicalRecord();

        if (medicalRecord == null) {
            System.out.println("Roditelj nema medicinski karton!");
            return null;
        }

        return repository.findSpecialistExaminationByMedicalRecordRecordId(medicalRecord.getRecordId());
    }

    @Override
    public List<SpecialistExamination> getChildSpecialistExaminations(int index) {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Parent parent = loginSessionHandler.getParent(sessionID);

        if(parent == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        if (index >= parent.getChildren().size()) {
            return null;
        }

        Child child = parent.getChildren().get(index);
        if (child == null) {
            System.out.println("Roditelj nema djecu!");
            return null;
        }

        MedicalRecord medicalRecord = child.getMedicalRecord();
        if (medicalRecord == null) {
            System.out.println("Roditelj nema medicinski karton!");
            return null;
        }

        return repository.findSpecialistExaminationByMedicalRecordRecordId(medicalRecord.getRecordId());
    }
}
