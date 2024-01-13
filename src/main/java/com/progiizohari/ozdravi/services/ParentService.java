package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Notification;
import com.progiizohari.ozdravi.domain.Parent;

import java.util.List;

public interface ParentService {

    public String add(Parent parent);
    public List<Parent> getAll();
    public Parent getByOIB(String OIB);
    public boolean remove(Parent parent);
    public boolean remove(int id);
    public boolean edit(int id, Parent newParentData);
}