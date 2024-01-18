package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.MedicalRecord;
import com.progiizohari.ozdravi.repositories.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService{

    @Autowired
    private MedicalRecordRepository repository;

    @Override
    public MedicalRecord getByRecordId(int recordId) {
        return repository.findByRecordId(recordId);
    }

    @Override
    public boolean setCurrentDiagnosis(String currentDiagnosis, int recordId) {
        MedicalRecord medicalRecord = repository.findByRecordId(recordId);
        medicalRecord.setCurrentDiagnosis(currentDiagnosis);

        repository.save(medicalRecord);


        if (medicalRecord.getCurrentDiagnosis() == currentDiagnosis) {
            return true;
        }
        return false;
    }
}
