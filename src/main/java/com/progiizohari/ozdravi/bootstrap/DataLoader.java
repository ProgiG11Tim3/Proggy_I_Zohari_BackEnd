package com.progiizohari.ozdravi.bootstrap;

import com.progiizohari.ozdravi.domain.*;
import com.progiizohari.ozdravi.repositories.*;
import com.progiizohari.ozdravi.util.Argon2Crypting;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
    private final SickNoteRepository sickNoteRepository;
    private final SpecialistExaminationRepository specialistExaminationRepository;
    private final SickLeaveRecommendationRepository sickLeaveRecommendationRepository;

    public DataLoader(Argon2Crypting argon2, DoctorRepository doctorRepository, PediatricianRepository pediatricianRepository, ParentRepository parentRepository, ChildRepository childRepository, NotificationRepository notificationRepository
                      , MedicalRecordRepository medicalRecordRepository, MedicalReportRepository medicalReportRepository, ExaminationRepository examinationRepository, SickNoteRepository sickNoteRepository,
                      SpecialistExaminationRepository specialistExaminationRepository, SickLeaveRecommendationRepository sickLeaveRecommendationRepository) {
        this.argon2 = argon2;
        this.doctorRepository = doctorRepository;
        this.pediatricianRepository = pediatricianRepository;
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
        this.notificationRepository = notificationRepository;
        this.medicalRecordRepository = medicalRecordRepository;
        this.medicalReportRepository = medicalReportRepository;
        this.examinationRepository = examinationRepository;
        this.sickNoteRepository = sickNoteRepository;
        this.specialistExaminationRepository = specialistExaminationRepository;
        this.sickLeaveRecommendationRepository = sickLeaveRecommendationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Loading data into database...");

        List<Doctor> doctors = new ArrayList<>(Arrays.asList(
                new Doctor("Ana", "Ivanović", LocalDate.of(1977, 12, 3), "anaIvanovic", argon2.HashPassword("anaIvanovic"), "0992280353", "ana.ivanovic@gmail.com", null, null),
                new Doctor("Marko", "Petrović", LocalDate.of(1985, 5, 15), "markoPetrovic", argon2.HashPassword("markoPetrovic"), "0992280354", "marko.petrovic@gmail.com", null, null),
                new Doctor("Jelena", "Kovač", LocalDate.of(1990, 8, 27), "jelenaKovac", argon2.HashPassword("jelenaKovac"), "0992280355", "jelena.kovac@gmail.com", null, null)
        ));
        List<Pediatrician> pediatricians = new ArrayList<>(Arrays.asList(
                new Pediatrician("Ana", "Pedić", LocalDate.of(1980, 4, 12), "anaPedic", argon2.HashPassword("anaPedic"), "0981239832", "ana.pedic@gmail.com", null),
                new Pediatrician("Marko", "Malić", LocalDate.of(1975, 6, 5), "markoMalic", argon2.HashPassword("markoMalic"), "0982345678", "marko.malic@gmail.com", null),
                new Pediatrician("Jelena", "Šimić", LocalDate.of(1988, 9, 20), "jelenaSimic", argon2.HashPassword("jelenaSimic"), "0983456789", "jelena.simic@gmail.com", null)
        ));
        List<Parent> parents = new ArrayList<>(Arrays.asList(
                new Parent("12345678901", "Petra", "Horvat", LocalDate.of(1980, 12, 4), "petraHorvat", argon2.HashPassword("petraHorvat"), "0971234567", "petra.horvat@gmail.com", 10000, "Zagreb", "telekom@t-com.hr", null, doctors.get(0), null, null),
                new Parent("23456789012", "Luka", "Kovač", LocalDate.of(1985, 5, 18), "lukaKovac", argon2.HashPassword("lukaKovac"), "0972345678", "luka.kovac@gmail.com", 12000, "Split", "vipnet@vip.hr", null, doctors.get(0), null, null),
                new Parent("34567890123", "Ivona", "Novak", LocalDate.of(1978, 8, 23), "ivonaNovak", argon2.HashPassword("ivonaNovak"), "0973456789", "ivona.novak@gmail.com", 8000, "Osijek", "inet@inet.hr", null, doctors.get(1), null, null),
                new Parent("45678901234", "Nikola", "Babić", LocalDate.of(1982, 3, 7), "nikolaBabic", argon2.HashPassword("nikolaBabic"), "0974567890", "nikola.babic@gmail.com", 15000, "Rijeka", "optika@optinet.hr", null, doctors.get(1), null, null),
                new Parent("56789012345", "Mia", "Radić", LocalDate.of(1990, 6, 15), "miaRadic", argon2.HashPassword("miaRadic"), "0975678901", "mia.radic@gmail.com", 11000, "Zadar", "nttdata@nttdata.hr", null, doctors.get(2), null, null),
                //ostavi dino saurica bez kartona jer treba za jedan test case
                new Parent("48249825043", "Dino", "Saurić", LocalDate.of(1990, 6, 15), "dinoSauric", argon2.HashPassword("dinoSauric"), "0978901424", "dino.sauric@gmail.com", 11000, "Zadar", "ntt@nttdata.hr", null, doctors.get(2), null, null)
        ));
        List<Child> children = new ArrayList<>(Arrays.asList(
                new Child("29081734199", "Dorian", "Gray", LocalDate.of(2013, 6, 3), "OŠ Dobriše Cesarić", "os.cesaric@gmail.com", parents.get(0), pediatricians.get(0), null),
                new Child("07101328764", "Nino", "Marinić", LocalDate.of(2016, 12, 5), "OŠ Dobriše Cesarić", "os.cesaric@gmail.com", parents.get(0), pediatricians.get(0), null),
                new Child("15052543872", "Lara", "Kraljević", LocalDate.of(2012, 2, 4), "OŠ Dobriše Cesarić", "os.cesaric@gmail.com", parents.get(1), pediatricians.get(0), null),
                new Child("03111219985", "Leon", "Pavić", LocalDate.of(2013, 4, 1), "OŠ Gustava Matoša", "os.matos@gmail.com", parents.get(1), pediatricians.get(1), null),
                new Child("22070556789", "Petra", "Šimić", LocalDate.of(2014, 12, 5), "OŠ Gustava Matoša", "os.matos@gmail.com", parents.get(2), pediatricians.get(1), null),
                new Child("18080412345", "David", "Vidović", LocalDate.of(2016, 7, 23), "OŠ Gustava Matoša", "os.matos@gmail.com", parents.get(2), pediatricians.get(1), null),
                new Child("09121087653", "Klara", "Horvat", LocalDate.of(2013, 5, 25), "OŠ Gustava Matoša", "os.matos@gmail.com", parents.get(3), pediatricians.get(2), null),
                new Child("26030634567", "Roko", "Perić", LocalDate.of(2017, 9, 12), "OŠ Gustava Matoša", "os.matos@gmail.com", parents.get(3), pediatricians.get(2), null),
                new Child("12121465432", "Iva", "Mlinarić", LocalDate.of(2010, 9, 24), "OŠ Siniša Vuce", "os.vuco@gmail.com", parents.get(4), pediatricians.get(2), null),
                new Child("10100198761", "Lovro", "Rukavina", LocalDate.of(2014, 3, 1), "OŠ Siniša Vuce", "os.vuco@gmail.com", parents.get(4), pediatricians.get(2), null)
        ));
        List<Notification> notifications = new ArrayList<>(Arrays.asList(
//              child
                new Notification(parents.get(0), children.get(0), "Važna obavijest!", "Dijete je danas prošlo pregled i sve je u redu."),
                new Notification(parents.get(0), children.get(0), "Nove informacije", "Molimo vas da pregledate ažurirane informacije o djetetu."),
                new Notification(parents.get(0), children.get(0), "Podsjetnik", "Sutra je zakazan pregled djeteta."),
                new Notification(parents.get(0), children.get(1), "Hitna obavijest", "Potrebno je hitno pregledati najnovije rezultate dijagnostičkih testova."),
                new Notification(parents.get(0), children.get(1), "Važna napomena", "Dijete ne smije jesti gluten."),
                new Notification(parents.get(0), children.get(1), "Zakazan novi pregled", "Pregled je zakazan u četvrtak u 13:00."),
                new Notification(parents.get(1), children.get(2), "Novosti", "Pročitajte najnovije informacije o zdravlju djeteta."),
                new Notification(parents.get(1), children.get(2), "Obavijest od kirurga", "Operacija je prošla dobro."),
                new Notification(parents.get(1), children.get(2), "Hitna situacija", "Dijete treba posebnu pažnju i dodatne preglede."),
                new Notification(parents.get(1), children.get(3), "Upozorenje", "Imamo važno upozorenje vezano uz zdravstveno stanje djeteta."),
                new Notification(parents.get(1), children.get(3), "Sretan rođendan!", "Danas je rođendan djeteta. Kupite mu poklone!"),
                new Notification(parents.get(1), children.get(3), "Stomatološki pregled", "Dijete se mora naručiti stomatologu."),
                new Notification(parents.get(2), children.get(4), "Važna obavijest od patronažne sestre", "Dijete se loše ponaša u bolnici."),
                new Notification(parents.get(2), children.get(4), "Pregled rezultata", "Rezultati testiranja su dostupni."),
                new Notification(parents.get(2), children.get(4), "Status dijeteta", "Dijete je stabilno."),
                new Notification(parents.get(2), children.get(5), "Savjet roditeljima", "Kako pravilno podržati dijete tijekom boravka u bolnici."),
                new Notification(parents.get(2), children.get(5), "Najnovije vijesti", "Dijete je uključeno u poseban projekt. Pročitajte više."),
                new Notification(parents.get(2), children.get(5), "Rezultati testiranja", "Stigli su rezultati testiranja."),
                new Notification(parents.get(3), children.get(6), "Obavijest od pedijatra", "Dijete ima zakazan pregled kod pedijatra."),
                new Notification(parents.get(3), children.get(6), "Raspored pregleda", "Provjerite raspored pregleda djeteta."),
                new Notification(parents.get(3), children.get(6), "Važno upozorenje", "Pregledajte hitne informacije o zdravstvenom stanju djeteta."),
                new Notification(parents.get(3), children.get(7), "Obavijest od pedijatra", "Molimo roditelje da pregledaju dijecu na krpelje."),
                new Notification(parents.get(3), children.get(7), "Novi materijali", "Dostupni su novi edukativni materijali za dijete."),
                new Notification(parents.get(3), children.get(7), "Važna obavijest", "Pozivamo roditelje na sastanak vezan uz posebne potrebe djeteta."),
                new Notification(parents.get(4), children.get(8), "Poziv na donacije", "Hitno potrebne donacije bolnici."),
                new Notification(parents.get(4), children.get(8), "Pregled nakon krvne pretrage", "Molimo dođite na pregled."),
                new Notification(parents.get(4), children.get(8), "Posebna obavijest", "Molim Vas dođite u bolnicu."),
                new Notification(parents.get(4), children.get(9), "Zakazan razgovor", "Razgovor s pedijatrom je zakazan za idući tjedan."),
                new Notification(parents.get(4), children.get(9), "Poteškoća u govoru", "Molim Vas zakazati termin s logopedom."),
                new Notification(parents.get(4), children.get(9), "Kupovina kolica", "Vaše dijete će trebati kolica."),
//              parent
                new Notification(parents.get(0), null, "Božićni humanitarni koncert", "Božićni humanitarni koncert za prikupljanje sredstava biti će održan ovu subotu."),
                new Notification(parents.get(1), null, "Božićni humanitarni koncert", "Božićni humanitarni koncert za prikupljanje sredstava biti će održan ovu subotu."),
                new Notification(parents.get(2), null, "Božićni humanitarni koncert", "Božićni humanitarni koncert za prikupljanje sredstava biti će održan ovu subotu."),
                new Notification(parents.get(3), null, "Božićni humanitarni koncert", "Božićni humanitarni koncert za prikupljanje sredstava biti će održan ovu subotu."),
                new Notification(parents.get(4), null, "Božićni humanitarni koncert", "Božićni humanitarni koncert za prikupljanje sredstava biti će održan ovu subotu.")
        ));
        List<MedicalRecord> medicalRecords = new ArrayList<>(Arrays.asList(
//              parent
                new MedicalRecord("Nema trenutne dijagnoze", "Nema alergije", parents.get(0), null, null),
                new MedicalRecord("Srčana anemija", "Paracetamol", parents.get(1), null, null),
                new MedicalRecord("Psihoza", "Nema alergije", parents.get(2), null, null),
                new MedicalRecord("Invalid", "Orasi i gluten", parents.get(3), null, null),
                new MedicalRecord("Nema trenutne dijagnoze", "Grinje", parents.get(4), null, null),
//              child
                new MedicalRecord("Nema trenutne dijagnoze", "Grinje", children.get(0), null, null),
                new MedicalRecord("Nema trenutne dijagnoze", "Nema alergije", children.get(1), null, null),
                new MedicalRecord("Želučani refluks", "THC", children.get(2), null, null),
                new MedicalRecord("Nedostatak testosterona", "Kamilica, pelud", children.get(3), null, null),
                new MedicalRecord("Nema trenutne dijagnoze", "Nema alergije", children.get(4), null, null),
                new MedicalRecord("Nema trenutne dijagnoze", "Nema alergije", children.get(5), null, null),
                new MedicalRecord("Invalid", "Nema alergije", children.get(6), null, null),
                new MedicalRecord("Dermatitis", "Pčele", children.get(7), null, null),
                new MedicalRecord("Upala sinusa", "Paracetamol", children.get(8), null, null),
                new MedicalRecord("Slomljena noga", "Penicilin", children.get(9), null, null)
        ));
        List<MedicalReport> medicalReports = new ArrayList<>(Arrays.asList(
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,1,12,56)), "Pacijent dolazi radi prehlade, poslan na kućni odmor.", medicalRecords.get(0), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,2,13,43)), "Pacijent dolazi radi pogoršanja stanja. Poslan na hitnu.", medicalRecords.get(0), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,2,12,32)), "Pacijent dolazi radi brzog kucanja srca. Poslan specijalistu.", medicalRecords.get(1), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,3,14,42)), "Pacijent dolazi radi cijepljenja protiv COVID-19. Cijepljenje uspješno.", medicalRecords.get(1), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,3,15,12)), "Pacijent dolazi radi glasova u glavi. Upućen specijalistu.", medicalRecords.get(2), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,4,16,45)), "Pacijent dolazi radi upisa nalaza u karton.", medicalRecords.get(2), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,4,12,34)), "Pacijent dolazi radi bolova u ruci. Upućen doma.", medicalRecords.get(3), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,5,17,12)), "Pacijent dolazi radi pogoršanja stanja. Poslan na hitnu.", medicalRecords.get(3), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,5,10,54)), "Pacijent dolazi radi povraćanja. Prepisana terapija.", medicalRecords.get(4), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,6,16,34)), "Pacijent dolazi radi ponovnog povraćanja. Prepisana druga terapija.", medicalRecords.get(4), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,6,9,2)), "Pacijent doživljava niz neobjašnjivih simptoma poput blagog vrtoglavice, svjetlucanja pred očima i povremenih bolova u trbuhu.", medicalRecords.get(5), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,7,12,52)), "Pacijent tvrdi da je doživio iznenadni porast kreativnosti koji ga čini nemirnim te želi konzultirati stručnjaka.", medicalRecords.get(5), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,7,11,22)), "Osoba tvrdi da osjeća bolove u ljubavi i želi konzultirati ljekara za emocionalnu pomoć.", medicalRecords.get(6), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,8,16,12)), "Pacijent tvrdi da često sanjari o fantastičnim svjetovima i želi provjeriti ima li to veze s njegovim mentalnim zdravljem.", medicalRecords.get(6), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,8,12,12)), "Osoba tvrdi da primjećuje sjaj u vlastitim očima i osjeća se prezdravo, želi saznati je li sve u redu.", medicalRecords.get(7), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,9,17,22)), "Pacijent tvrdi da može razgovarati s vlastitim organima i želi medicinsko objašnjenje za to iskustvo.", medicalRecords.get(7), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,9,10,22)), "Osoba tvrdi da povremeno gubi osjet mirisa boja, ali samo kad gleda umjetničke slike.", medicalRecords.get(8), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,10,11,32)), "Pacijent tvrdi da ne može prestati smijati se nakon gledanja određenog smiješnog videa te želi konzultirati stručnjaka o tome.", medicalRecords.get(8), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,10,12,12)), "Osoba tvrdi da može čitati misli bliskih ljudi i želi razgovarati s liječnikom o tome.", medicalRecords.get(9), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,11,19,32)), "Pacijent tvrdi da postaje nespretan dok sanja i često pada iz kreveta te želi konzultirati liječnika o ovom \"problemu\".", medicalRecords.get(9), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,11,9,22)), "Pacijent tvrdi da povremeno doživljava trenutke iz prošlosti kao da se događaju sada, te želi konzultirati stručnjaka o ovom fenomenu.", medicalRecords.get(10), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,12,12,12)), "Osoba tvrdi da se osjeća ovisnom o gledanju crtića i zabrinuta je zbog toga.", medicalRecords.get(10), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,12,10,12)), "Pacijent tvrdi da sanja da je vampir i želi razgovarati s liječnikom o svojim noćnim avanturama.", medicalRecords.get(11), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,13,19,52)), "Osoba tvrdi da vidi nevidljivu svjetlost koja ju okružuje i želi utvrditi ima li to veze s njezinim zdravljem.", medicalRecords.get(11), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,13,9,42)), "Pacijent tvrdi da stvara kompleksne pjesme dok spava i želi saznati je li to normalno ili zabrinjavajuće.", medicalRecords.get(12), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,14,12,2)), "Osoba tvrdi da može komunicirati telepatski sa svojim kućnim ljubimcem i želi stručno mišljenje o toj vezi.", medicalRecords.get(12), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,14,8,42)), "Pacijent tvrdi da osjeća alergijske reakcije kad koristi virtualnu stvarnost te želi konzultirati stručnjaka o tome.", medicalRecords.get(13), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,15,15,12)), "Osoba tvrdi da osjeća potrebu za stalnim izražavanjem osmijeha i želi konzultirati liječnika o svojoj poticajnoj ovisnosti.", medicalRecords.get(13), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,15,12,52)), "Pacijent tvrdi da sanja kako pliva u zraku noću te želi saznati ima li to veze s njegovim zdravljem.", medicalRecords.get(14), null),
                new MedicalReport(Timestamp.valueOf(LocalDateTime.of(2024, 1,16,19,42)), "Osoba tvrdi da se neprestano smije dok obavlja kupovinu i želi konzultirati stručnjaka o svom čudnom ponašanju.", medicalRecords.get(14), null)
        ));
        List<Examination> examinations = new ArrayList<>(Arrays.asList(
                new Examination("Fluktuirajući emocionalni sindrom (FES): Pacijent izvješćuje o naglim promjenama emocionalnog stanja bez očitog uzroka.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "D", medicalRecords.get(0)),
                new Examination("Sanjarski poremećaj stvarnosti (SPS): Osoba doživljava intenzivne snove koji utječu na njezino dnevno funkcioniranje.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "N", "D", medicalRecords.get(1)),
                new Examination("Vampirski sanjski poremećaj (VSP): Pacijent izvješćuje o učestalim snovima u kojima se doživljava kao vampir.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "D", medicalRecords.get(2)),
                new Examination("Kreativna nesanica (KN): Osoba doživljava nesanicu zbog pretjerane kreativnosti i maštovitih misli tijekom noći.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "D", medicalRecords.get(3)),
                new Examination("Telepatski sindrom s ljubimcima (TSL): Pacijent tvrdi da može komunicirati telepatski sa svojim kućnim ljubimcem.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "N", "D", medicalRecords.get(4)),
                new Examination("Alergija na virtualnu stvarnost (AVS): Osoba doživljava alergijske reakcije kad koristi virtualnu stvarnost.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "N", "D", medicalRecords.get(5)),
                new Examination("Noćno plivanje u zraku (NPZ): Pacijent tvrdi da sanja o plivanju u zraku tijekom noći.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "N", medicalRecords.get(6)),
                new Examination("Osmijehomanija (OM): Osoba osjeća neodoljivu potrebu za stalnim izražavanjem osmijeha.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "D", medicalRecords.get(7)),
                new Examination("Misteriozni sindrom simpatičnosti (MSS): Pacijent izvješćuje o doživljavanju snažnog suosjećanja prema nepoznatim ljudima.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "D", medicalRecords.get(8)),
                new Examination("Retroaktivna pamćenja (RP): Osoba povremeno doživljava trenutke iz prošlosti kao da se događaju sada.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "D", medicalRecords.get(9)),
                new Examination("Nesanica zbog crtića (NC): Pacijent doživljava nesanicu zbog pretjerane gledanosti crtića.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "N", medicalRecords.get(10)),
                new Examination("Stvaranje snova u snu (SSS): Osoba tvrdi da stvara kompleksne snove dok spava.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "D", medicalRecords.get(11)),
                new Examination("Ovisnost o crtićima (OC): Pacijent se osjeća ovisnim o gledanju crtića.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "D", medicalRecords.get(12)),
                new Examination("Ljubavni bolovi (LB): Osoba doživljava emocionalnu bol povezanu s ljubavnim iskustvima.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "D", "N", medicalRecords.get(13)),
                new Examination("Sanjarenje o fantastičnim svjetovima (SFS): Pacijent često sanjari o nevjerojatnim svjetovima i iskustvima.", Timestamp.valueOf(LocalDateTime.of(2024, 1,12,16,32)), "N", "D", medicalRecords.get(14))
        ));
        List<SickNote> sickNotes = new ArrayList<>(Arrays.asList(
                new SickNote(children.get(0), "Egzistencijalna kriza u igri: Dijete tvrdi da je suočeno s egzistencijalnom krizom u svom imaginarnom svijetu igre te mora ostati kod kuće kako bi riješilo te unutarnje konflikte."),
                new SickNote(children.get(1), "Prolazna alergija na kemijske olovke: Dijete tvrdi da je razvilo prolaznu alergiju na miris kemijskih olovaka i ne može podnijeti okolinu u učionici."),
                new SickNote(children.get(2), "Napad tajanstvenih svjetlucavih leptira: Dijete tvrdi da ga napadaju tajanstveni svjetlucavi leptiri, što mu otežava fokusiranje na nastavu."),
                new SickNote(children.get(3), "Poteškoće u komunikaciji s papirima: Dijete tvrdi da ima teškoća u uspostavi komunikacije s papirom te stoga ne može obavljati pisanje zadaća ili bilješki."),
                new SickNote(children.get(4), "Nesposobnost sučeljavanja s predavanjem na daljinu: Dijete tvrdi da nije u stanju suočiti se s predavanjem putem interneta jer osjeća da ga virtualna učionica promatra."),
                new SickNote(children.get(5), "Izvanredna privrženost kućnim ljubimcima: Dijete tvrdi da osjeća izvanrednu odgovornost prema svojim kućnim ljubimcima i ne želi ih ostaviti samima kod kuće."),
                new SickNote(children.get(6), "Epidemija mjehura sapunice: Dijete tvrdi da u školi vlada epidemija mjehura sapunice, a boji se zaraze."),
                new SickNote(children.get(7), "Poteškoće u snalaženju među vršnjacima: Dijete tvrdi da se suočava s poteškoćama u uspostavi socijalnih veza s vršnjacima i osjeća se nelagodno u njihovom društvu."),
                new SickNote(children.get(8), "Virus izmišljenih domaćih zadaća: Dijete tvrdi da je zaraženo virusom izmišljenih domaćih zadaća i ne može koncentrirano raditi na njima."),
                new SickNote(children.get(9), "Nagli rast kose koji ometa vid: Dijete tvrdi da mu je kosa iznenada narasla i sada mu ometa vid, pa mora ostati kod kuće dok ne pronađe rješenje za ovu kriznu situaciju.")
        ));
        List<SpecialistExamination> specialistExaminations = new ArrayList<>(Arrays.asList(
                new SpecialistExamination("Oftalmolog (pregled vida): Stručnjak će ispitali vaš vid kroz različite testove poput provjere oštrine vida, provjere boje, i pregleda očne pozadine kako bi dijagnosticirao i liječio probleme s vidom.", "KBC Rebro", medicalRecords.get(0)),
                new SpecialistExamination("Dermatolog (pregled kože): Liječnik će pregledati vašu kožu kako bi identificirao promjene, madeže ili kožne bolesti. Moguće je i izvršiti biopsiju kože radi daljnje analize.", "KBC Rebro", medicalRecords.get(1)),
                new SpecialistExamination("Kardiolog (kardiološki pregled): Specijalist će pregledati vaše srce pomoću elektrokardiograma (EKG), auskultacije i drugih testova kako bi procijenio zdravlje srca i identificirao moguće probleme.", "KBC Rebro", medicalRecords.get(2)),
                new SpecialistExamination("Ginekolog (ginekološki pregled): Specijalist će pregledati reproduktivne organe žene, uključujući pregled vrata maternice i dojki. Može provesti i PAPA test ili mamografiju.", "KBC Dubrava", medicalRecords.get(3)),
                new SpecialistExamination("Ortoped (ortopedski pregled): Pregleda zglobove, kosti i mišiće kako bi dijagnosticirao i liječio problema s mišićno-koštanim sustavom.", "KBC Dubrava", medicalRecords.get(4)),
                new SpecialistExamination("Neurolog (neurološki pregled): Pregledava živčani sustav, provodeći testove poput refleksa, provjere koordinacije i procjene senzacija kako bi dijagnosticirao neurološke poremećaje.", "KBC Dubrava", medicalRecords.get(5)),
                new SpecialistExamination("Gastroenterolog (gastroenterološki pregled): Pregledava probavni sustav, uključujući želudac, crijeva i jetru, pomoću različitih testova poput endoskopije ili kolonoskopije.", "KBC Dubrava", medicalRecords.get(6)),
                new SpecialistExamination("Psihijatar (psihijatrijski pregled): Razgovara s pacijentom o emocionalnom i mentalnom zdravlju te postavlja dijagnozu i pruža terapiju.", "KBC Merkur", medicalRecords.get(7)),
                new SpecialistExamination("Endokrinolog (endokrinološki pregled): Pregledava hormonalni sustav tijela, uključujući štitnjaču, nadbubrežne žlijezde i gušteraču.", "KBC Merkur", medicalRecords.get(8)),
                new SpecialistExamination("Pulmolog (pulmološki pregled): Pregledava dišni sustav i pluća kako bi dijagnosticirao i liječio probleme s disanjem i respiratornim sustavom.", "KBC Merkur", medicalRecords.get(9)),
                new SpecialistExamination("Urolog (urološki pregled): Pregledava mokraćni sustav, uključujući bubrege, mjehur i genitalije, kako bi dijagnosticirao i liječio probleme urogenitalnog područja.", "KBC Merkur", medicalRecords.get(10)),
                new SpecialistExamination("Reumatolog (reumatološki pregled): Pregledava zglobove, mišiće i kosti kako bi dijagnosticirao i liječio reumatske bolesti.", "KBC Sestre Milosrdnice", medicalRecords.get(11)),
                new SpecialistExamination("Alergolog (alergološki pregled): Pregledava pacijenta kako bi identificirao alergijske reakcije i odredio uzročnike alergija.", "KBC Sestre Milosrdnice", medicalRecords.get(12)),
                new SpecialistExamination("ENT specijalist (otorinolaringološki pregled): Pregledava uši, nos i grlo kako bi dijagnosticirao i liječio probleme u tim područjima.", "KBC Sestre Milosrdnice", medicalRecords.get(13)),
                new SpecialistExamination("Nutricionist (nutricionistički pregled): Pregledava prehrambene navike, zdravstvene uvjete i ciljeve pacijenta kako bi pružio prilagođene prehrambene preporuke.", "KBC Sestre Milosrdnice", medicalRecords.get(14))
        ));
        List<SickLeaveRecommendation> sickLeaveRecommendations = new ArrayList<>(Arrays.asList(
                new SickLeaveRecommendation(doctors.get(0), "Respiratorna infekcija: Preporučujem da ostanete kod kuće kako biste spriječili širenje respiratornih infekcija. Odmaranje i ograničavanje kontakta s drugima pomoći će vašem tijelu da se oporavi bez izlaganja drugima.", "telekom@t-com.hr", parents.get(0)),
                new SickLeaveRecommendation(doctors.get(0), "Postoperativna njega: Kako biste osigurali uspješan oporavak nakon operacije, preporučujem da ostanete kod kuće u mirnom okruženju. Odmor je ključan za brži oporavak.", "vipnet@vip.hr", parents.get(1)),
                new SickLeaveRecommendation(doctors.get(1), "Kontakt s potencijalnim alergenima: S obzirom na vašu dijagnozu alergije, preporučujem izbjegavanje kontakta s poznatim alergenima. Ostanak kod kuće pomoći će u smanjenju izloženosti i ublažavanju simptoma.", "inet@inet.hr", parents.get(2)),
                new SickLeaveRecommendation(doctors.get(1), "Karantena radi zarazne bolesti: Na temelju rezultata testiranja, preporučujem karantenu kako biste spriječili širenje zarazne bolesti. Ostanak kod kuće pomoći će zaštititi druge članove zajednice.", "optika@optinet.hr", parents.get(3)),
                new SickLeaveRecommendation(doctors.get(2), "Zdravstveno stanje trudnice: S obzirom na vašu trenutačnu trudnoću, preporučujem ograničavanje izlazaka iz kuće kako biste smanjili rizik od komplikacija. Pridržavajte se preporuka za odmor i oprez kako biste osigurali siguran tijek trudnoće.", "nttdata@nttdata.hr", parents.get(4))
        ));

        doctorRepository.saveAll(doctors);
        pediatricianRepository.saveAll(pediatricians);
        parentRepository.saveAll(parents);
        childRepository.saveAll(children);
        notificationRepository.saveAll(notifications);
        medicalRecordRepository.saveAll(medicalRecords);
        medicalReportRepository.saveAll(medicalReports);
        examinationRepository.saveAll(examinations);
        sickNoteRepository.saveAll(sickNotes);
        specialistExaminationRepository.saveAll(specialistExaminations);
        sickLeaveRecommendationRepository.saveAll(sickLeaveRecommendations);

        System.out.println("...loading successful!");
    }
}
