package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.Child;
import com.progiizohari.ozdravi.domain.ChoseProfileEntry;
import com.progiizohari.ozdravi.domain.Parent;
import com.progiizohari.ozdravi.util.LoginSessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    LoginSessionHandler loginSessionHandler;

    @RequestMapping(value = "/odabirprofila", method = RequestMethod.GET)
    public ResponseEntity<List<ChoseProfileEntry>> odabirprofila() {
        // is parent logged in guard
        String sessionID = RequestContextHolder.currentRequestAttributes().getSessionId();
        Parent parent = loginSessionHandler.getParent(sessionID);
        if (parent == null) {
            return ResponseEntity.badRequest().body(null);
        }

        List<ChoseProfileEntry> return_list = new ArrayList<>();

        ChoseProfileEntry parent_entry = new ChoseProfileEntry(
                "Parent",
                parent.getNameParent(),
                parent.getLastNameParent(),
                parent.getOIB(),
                parent.getDateOfBirthParent().toString(),
                "/parentprofile");
        return_list.add(parent_entry);

        List<Child> children = parent.getChildren();
        for (int i = 0; i < children.size(); i++) {
            ChoseProfileEntry child_entry = new ChoseProfileEntry(
                    "Child",
                    children.get(i).getNameChild(),
                    children.get(i).getLastNameChild(),
                    children.get(i).getOIB(),
                    children.get(i).getDateOfBirthChild().toString(),
                    "/childprofile" + Integer.toString(i));
            return_list.add(child_entry);
        }

        return ResponseEntity.ok(return_list);
    }
}
