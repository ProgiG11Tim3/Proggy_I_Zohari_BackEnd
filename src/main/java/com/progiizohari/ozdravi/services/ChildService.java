package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Child;

import java.util.List;

public interface ChildService {

        public String getChildByOIB(String oib);
        public List<Child> getAll();
        public boolean add(Child child);
        public boolean remove(Child child);
        public boolean edit(int id, Child child);

}
