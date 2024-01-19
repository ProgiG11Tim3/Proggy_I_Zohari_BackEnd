package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.MedicalRecord;
import com.progiizohari.ozdravi.domain.MedicalReport;
import com.progiizohari.ozdravi.repositories.MedicalRecordRepository;
import com.progiizohari.ozdravi.repositories.MedicalReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalReportServiceImpl implements MedicalReportService{

    @Autowired
    private MedicalReportRepository repository;

    @Override
    public MedicalReport add(MedicalReport _medicalReport) {
        for (MedicalReport medicalReport : repository.findAll()) {
            if (medicalReport.equalValues(_medicalReport)) {
                return null;
            }
        }
        repository.save(_medicalReport);
        return repository.save(_medicalReport);
    }

    @Override
    public boolean edit(int id, MedicalReport newMedicalReport) {
        for (MedicalReport medicalReport : repository.findAll()) {
            if (medicalReport.getReportId() == id) {
                medicalReport.setDateOfReport(newMedicalReport.getDateOfReport());
                medicalReport.setMedicalRecord(newMedicalReport.getMedicalRecord());
                medicalReport.setReportInformation(newMedicalReport.getReportInformation());
                medicalReport.setFileDBS(newMedicalReport.getFileDBS());
                repository.save(medicalReport);

                return true;
            }
        }
        return false;
    }

    @Override
    public MedicalReport getByReportId(int reportId) {
        return repository.findByReportId(reportId);
    }
}
