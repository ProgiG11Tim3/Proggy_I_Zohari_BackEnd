package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.MedicalRecord;
import com.progiizohari.ozdravi.domain.MedicalReport;

public interface MedicalReportService {
    public MedicalReport getByReportId(String reportId);
}
