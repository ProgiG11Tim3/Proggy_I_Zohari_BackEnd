package com.progiizohari.ozdravi.repositories;

import com.progiizohari.ozdravi.domain.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExaminationRepository extends JpaRepository<Examination, Integer> {

    List<Examination> findExaminationByMedicalRecordRecordId(int recordId);
}
