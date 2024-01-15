package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.SpecialistExamination;

import java.util.List;

public interface SpecialistExaminationService {

    List<SpecialistExamination> getParentSpecialistExaminations();
    List<SpecialistExamination> getChildSpecialistExaminations(int index);
}
