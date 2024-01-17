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
    public MedicalReport getByReportId(int reportId) {
        return repository.findByReportId(reportId);
    }
}
