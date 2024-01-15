package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.SickNote;

import java.util.List;

public interface SickNoteService {
    public String add(SickNote sickNote);

    public List<SickNote> getAllChildSickNotes(int index);
}
