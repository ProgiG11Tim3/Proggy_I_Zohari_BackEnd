package com.progiizohari.ozdravi.repositories;

import com.progiizohari.ozdravi.domain.MedicalRecord;
import com.progiizohari.ozdravi.domain.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalReportRepository extends JpaRepository<MedicalReport, Integer> {
    MedicalReport findByReportId(int reportId);

    MedicalReport findMedicalReportByReportId(int reportId);
}
