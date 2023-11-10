package com.progiizohari.ozdravi.repositories;

import com.progiizohari.ozdravi.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}