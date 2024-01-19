package com.progiizohari.ozdravi.services;

import com.progiizohari.ozdravi.domain.FileDB;
import com.progiizohari.ozdravi.domain.MedicalReport;
import com.progiizohari.ozdravi.repositories.FileRepository;
import com.progiizohari.ozdravi.repositories.MedicalReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileServiceImpl implements FileService{
    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private MedicalReportRepository medicalReportRepository;
    public FileDB storeFile(MultipartFile file, String message, String reportId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        int ID = Integer.parseInt(reportId);
        MedicalReport medicalReport = medicalReportRepository.findMedicalReportByReportId(ID);
        FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(), message, medicalReport);
        return fileRepository.save(FileDB);
    }

    @Override
    public FileDB getFile(String id) {
        return fileRepository.findById(id).get();
    }

    @Override
    public Stream<FileDB> getAllFiles() {
        return fileRepository.findAll().stream();
    }

    @Override
    public FileDB getFileByReportId(int reportId) {
        return fileRepository.findFileDBByMedicalReportReportId(reportId);
    }
}
