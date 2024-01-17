package com.progiizohari.ozdravi.repositories;

import com.progiizohari.ozdravi.domain.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {
    MedicalRecord findByRecordId( int recordId);
    MedicalRecord findByParent_OIB(String OIB);
    MedicalRecord findByChild_OIB(String OIB);
}
