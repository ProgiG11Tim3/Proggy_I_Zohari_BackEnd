package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Examination;
import com.progiizohari.ozdravi.domain.Parent;

import java.util.List;

public interface ExaminationService {
    public String add(Examination examination);
    List<Examination> getAllExaminations();
}
