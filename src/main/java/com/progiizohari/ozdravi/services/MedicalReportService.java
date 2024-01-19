package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.MedicalRecord;
import com.progiizohari.ozdravi.domain.MedicalReport;

public interface MedicalReportService {
    public MedicalReport getByReportId(int reportId);

    public MedicalReport add(MedicalReport medicalReport);

    public boolean edit(int id, MedicalReport medicalReport);
}
