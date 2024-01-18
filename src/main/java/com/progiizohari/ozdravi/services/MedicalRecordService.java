package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.MedicalRecord;

public interface MedicalRecordService {
    public MedicalRecord getByRecordId(int recordId);

    public boolean setCurrentDiagnosis(String currentDiagnosis, int recordId);
}
