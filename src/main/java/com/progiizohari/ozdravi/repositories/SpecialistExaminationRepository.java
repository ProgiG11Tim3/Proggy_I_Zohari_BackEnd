package com.progiizohari.ozdravi.repositories;

import com.progiizohari.ozdravi.domain.SpecialistExamination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialistExaminationRepository extends JpaRepository<SpecialistExamination, Integer> {

    List<SpecialistExamination> findSpecialistExaminationByMedicalRecordRecordId(int recordId);
}
