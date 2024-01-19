package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.FileDB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileService {
    public FileDB storeFile(MultipartFile file, String message, String reportId) throws IOException;

    public FileDB getFile(String id);

    public Stream<FileDB> getAllFiles();
}
