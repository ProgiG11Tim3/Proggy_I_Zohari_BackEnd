package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Child;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.domain.SickNote;
import com.progiizohari.ozdravi.repositories.SickNoteRepository;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

@Service
public class SickNoteServiceImpl implements SickNoteService{
    @Autowired
    private SickNoteRepository sickNoteRepository;

    @Autowired
    private LoginSessionHandler loginSessionHandler;

    @Override
    public String add(SickNote sickNote) {
        sickNoteRepository.save(sickNote);
        return sickNote.toString() + " successfully added!";
    }

    @Override
    public List<SickNote> getAllChildSickNotes(int index) {
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Parent parent = loginSessionHandler.getParent(sessionID);

        if(parent == null) {
            System.out.println("Nemas pristup!");
            return null;
        }

        if (index >= parent.getChildren().size()) {
            return null;
        }

        Child child = parent.getChildren().get(index);

        return sickNoteRepository.findAllByChild_OIB(child.getOIB());
    }


}
