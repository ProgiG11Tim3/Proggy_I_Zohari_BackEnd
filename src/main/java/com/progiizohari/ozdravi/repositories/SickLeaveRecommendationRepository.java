package com.progiizohari.ozdravi.repositories;

import com.progiizohari.ozdravi.domain.SickLeaveRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SickLeaveRecommendationRepository extends JpaRepository<SickLeaveRecommendation, Integer> {
    List<SickLeaveRecommendation> findByIsApproved(boolean b);
}
