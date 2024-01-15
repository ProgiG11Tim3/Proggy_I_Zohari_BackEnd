package com.progiizohari.ozdravi.bootstrap;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.repositories.*;
import com.progiizohari.ozdravi.util.Argon2Crypting;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final Argon2Crypting argon2;
    private final DoctorRepository doctorRepository;
    private final PediatricianRepository pediatricianRepository;
    private final ParentRepository parentRepository;
    private final ChildRepository childRepository;
    private final NotificationRepository notificationRepository;
    private final MedicalRecordRepository medicalRecordRepository;
    private final MedicalReportRepository medicalReportRepository;
    private final ExaminationRepository examinationRepository;
    private final FileRepository fileRepository;

    public DataLoader(Argon2Crypting argon2, DoctorRepository doctorRepository, PediatricianRepository pediatricianRepository, ParentRepository parentRepository, ChildRepository childRepository, NotificationRepository notificationRepository
    , MedicalRecordRepository medicalRecordRepository, MedicalReportRepository medicalReportRepository, ExaminationRepository examinationRepository, FileRepository fileRepository) {
        this.argon2 = argon2;
        this.doctorRepository = doctorRepository;
        this.pediatricianRepository = pediatricianRepository;
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
        this.notificationRepository = notificationRepository;
        this.medicalRecordRepository = medicalRecordRepository;
        this.medicalReportRepository = medicalReportRepository;
        this.examinationRepository = examinationRepository;
        this.fileRepository = fileRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Doctor doctor1 = new Doctor("Doktor", "Doktoric", LocalDate.of(1977, 12, 3), "doktorDoktoric", argon2.HashPassword("doktorka"), "0992280353", "doktor@gmail.com", null);
        Parent parent1 = new Parent("12345678901", "Roditelj", "Rodic", LocalDate.of(1980, 12, 4), "najroditelj", argon2.HashPassword("roditelj123"), "0992233344", "roditelj@gmail.com", 10000, "Zagreb", "tvrtka@gmail.com", null ,doctor1, null);
        Pediatrician pediatrician1 = new Pediatrician("Pedijatar", "Pedijatric", LocalDate.of(1980, 4, 12), "pedijatar", argon2.HashPassword("pedijatar123"), "0981239832", "pedijatar@gmail.com", null);
        Child child1 = new Child("34567887654", "Dijete", "Malo", LocalDate.of(2020, 6, 3), "OS ZaMaluDijecu", "zamale@gmail.com", parent1, pediatrician1, null);
        Notification notification1 = new Notification(parent1, child1, "Bolest lijevog kuka", "Postovani, vase dijete ima bolest lijevog kuka i zbog toga je osudjeno na crip walk, east coast mothafucka. Srdacan pozdrav, Pedijatar");
        Notification notification2 = new Notification(parent1, "Bolest najboljeg roditelja", "Postovani, u velikoj ste opasnosti jer vam iz bradavice raste kost, javite mi se sto prije, vas doktor Doktor Doktoric najdoktoriji");
        MedicalRecord medicalRecord1 = new MedicalRecord("Upala crijevnog otvora", "Nema alergije", child1,null, null, null);
        MedicalReport medicalReport1 = new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,3,16,32)), "Ima iskrivljena stopala poput bavlana na cesti 91. godine", medicalRecord1, null);
        Examination examination1 = new Examination("Stopala smrde uzasno", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "D", medicalRecord1);
        Examination examination2 = new Examination("Pazusi smrde uzasno", Timestamp.valueOf(LocalDateTime.of(2024, 1,13,16,32)), "D", "N", medicalRecord1);
        MedicalRecord medicalRecord_parent = new MedicalRecord("Nema dijagnozu!", "Alergija na grinje", null, parent1, null, null);
        MedicalReport medicalReport_parent = new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2023,7,12,15,23)), "Mnogo spolnih bolesti", medicalRecord_parent, null);
        Examination examination3 = new Examination("Sin izazvao alergijsku reakciju smrdljivim stopalima", Timestamp.valueOf(LocalDateTime.of(2024, 1,3,16,32)), "D", "D", medicalRecord_parent);
        Examination examination4 = new Examination("Opet na aparatima", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "N", medicalRecord_parent);

        doctorRepository.save(doctor1);
        parentRepository.save(parent1);
        pediatricianRepository.save(pediatrician1);
        childRepository.save(child1);
        notificationRepository.save(notification1);
        notificationRepository.save(notification2);
        medicalRecordRepository.save(medicalRecord1);
        medicalReportRepository.save(medicalReport1);
        examinationRepository.save(examination1);
        examinationRepository.save(examination2);
        medicalRecordRepository.save(medicalRecord_parent);
        medicalReportRepository.save(medicalReport_parent);
        examinationRepository.save(examination3);
        examinationRepository.save(examination4);
        System.out.println("Data loaded into the database.");
    }
}
