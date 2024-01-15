package com.progiizohari.ozdravi.repositories;

import com.progiizohari.ozdravi.domain.SickNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SickNoteRepository extends JpaRepository<SickNote, Integer> {

    List<SickNote> findAllByChild_OIB(String child_OIB);
}
