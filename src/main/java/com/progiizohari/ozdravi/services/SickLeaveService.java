package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.domain.SickLeaveRecommendation;

import java.util.List;

public interface SickLeaveService {
    public String add(SickLeaveRecommendation sickLeave);

    public List<SickLeaveRecommendation> getAll();

    public String approve(int id);

    List<SickLeaveRecommendation> getUnapproved();
}
