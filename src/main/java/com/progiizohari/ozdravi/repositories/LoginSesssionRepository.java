package com.progiizohari.ozdravi.repositories;

import com.progiizohari.ozdravi.domain.LoginSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginSesssionRepository extends JpaRepository<LoginSession, Integer> {
}
