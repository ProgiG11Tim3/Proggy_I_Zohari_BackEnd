package com.progiizohari.ozdravi.repositories;

import com.progiizohari.ozdravi.domain.SickNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SickNoteRepository extends JpaRepository<SickNote, Integer> {
}
