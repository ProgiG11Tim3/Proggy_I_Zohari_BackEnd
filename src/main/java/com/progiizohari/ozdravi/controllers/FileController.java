package com.progiizohari.ozdravi.controllers;

import com.progiizohari.ozdravi.domain.FileDB;
import com.progiizohari.ozdravi.domain.MedicalRecord;
import com.progiizohari.ozdravi.domain.MedicalReport;
import com.progiizohari.ozdravi.domain.ResponseFile;
import com.progiizohari.ozdravi.services.FileServiceImpl;
import com.progiizohari.ozdravi.services.MedicalRecordService;
import com.progiizohari.ozdravi.services.MedicalReportService;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    @Autowired
    private FileServiceImpl storageService;

    @Autowired
    private MedicalReportService medicalReportService;

    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("messageForDoc") String messageForDoc, @RequestParam("medicalRecord") String recordId) {
        String message = "";
        try {
            MedicalRecord medicalRecord = medicalRecordService.getByRecordId(Integer.parseInt(recordId));
            MedicalReport medicalReport = new MedicalReport(messageForDoc, medicalRecord);
            MedicalReport predaja = medicalReportService.add(medicalReport);
            storageService.storeFile(file, messageForDoc, Integer.toString(predaja.getReportId()));
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + " | " + e.getMessage();
            return ResponseEntity.badRequest().body(message);
        }
    }

    @GetMapping("/getFileByReportId/{id}")
    public ResponseEntity<byte[]> getFileByReportId(@PathVariable int id) {
        FileDB fileDB = storageService.getFileByReportId(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getFileId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        FileDB fileDB = storageService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }
}
