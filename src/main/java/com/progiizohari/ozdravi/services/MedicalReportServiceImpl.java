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
    public boolean add(MedicalReport _medicalReport) {
        for (MedicalReport medicalReport : repository.findAll()) {
            if (medicalReport.equalValues(_medicalReport)) {
                return false;
            }
        }
        repository.save(_medicalReport);
        return true;
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
