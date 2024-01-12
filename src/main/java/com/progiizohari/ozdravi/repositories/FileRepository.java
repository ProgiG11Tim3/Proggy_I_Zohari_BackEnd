package com.progiizohari.ozdravi.repositories;

import com.progiizohari.ozdravi.domain.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository  extends JpaRepository<FileDB, String> {
}
