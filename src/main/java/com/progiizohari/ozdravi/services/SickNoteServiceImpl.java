package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.SickNote;
import com.progiizohari.ozdravi.repositories.SickNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SickNoteServiceImpl implements SickNoteService{
    @Autowired
    private SickNoteRepository sickNoteRepository;

    @Override
    public String add(SickNote sickNote) {
        sickNoteRepository.save(sickNote);
        return sickNote.toString() + " successfully added!";
    }
}
