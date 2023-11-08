package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.Pediatrician;

import java.util.List;
import java.util.Optional;

public interface PediatricianService {

    public String add(Pediatrician pediatrician);
    public List<Pediatrician> getAll();
    public Optional<Pediatrician> getById(int Id);
}
