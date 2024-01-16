package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.SpecialistExamination;

import java.util.List;

public interface SpecialistExaminationService {

    public String add(SpecialistExamination specialistExamination);
    List<SpecialistExamination> getParentSpecialistExaminations();
    List<SpecialistExamination> getChildSpecialistExaminations(int index);
}
