package com.progiizohari.ozdravi.repositories;

import com.progiizohari.ozdravi.domain.Child;
import com.progiizohari.ozdravi.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Integer> {
    Child findByOIB(String oib);
}
