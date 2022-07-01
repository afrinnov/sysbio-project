package org.afrinnov.rnd.afrinnovdgs.service.adapters;

import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.*;
import org.afrinnov.rnd.afrinnovdgs.service.DossierManagementService;
import org.afrinnov.rnd.afrinnovdgs.service.dto.DossierId;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.List;

@Component
public class DummyDossierManagementService implements DossierManagementService {
    public Dossier getDossier(String dossierId) {
        return init();
    }

    public Patient getPatient(DossierId dossierId) {
        return getPatient();
    }

    public Prescripteur getPrescripteur(DossierId dossierId) {
        return getPrescripteur();
    }

    public List<DossierExam> getDossierExam(DossierId dossierId) {
        DossierExam dossierExam = new DossierExam();
        dossierExam.setDossierRef("012365478");
        dossierExam.setAmount(12D);
        dossierExam.setAuthor("Author");
        dossierExam.setStatus("REAL");
        dossierExam.setExamen(initExam());
        return List.of(dossierExam);
    }


    private Dossier init() {
        Dossier dossier = new Dossier();
        dossier.setEmergencyMode("URGENT");
        dossier.setEntryDate(OffsetDateTime.now());
        dossier.setCode("012365478");
        dossier.setPatientType("Simple");
        return dossier;
    }

    private Patient getPatient() {
        Patient patient = new Patient();
        patient.setEmail("patient@sysbio.org");
        patient.setName("Toulou");
        patient.setCode("P45852");
        patient.setAge("15");
        patient.setSex("M");
        return patient;
    }

    private Prescripteur getPrescripteur() {
        Prescripteur prescripteur = new Prescripteur();
        prescripteur.setEmail("prsysbio@sysbio.cm");
        prescripteur.setMatricule("012545");
        prescripteur.setTitle("Pr");
        prescripteur.setName("Momo");
        prescripteur.setPhone("+23765848952");
        prescripteur.setService("CHU");
        return prescripteur;
    }

    private Exam initExam() {
        Exam exam = new Exam();
        exam.setCode("001");
        exam.setDesignation("Exam ONE");
        exam.setPrix(10D);
        exam.setPrixPartenaire(12D);
        exam.setPrixUrgent(13D);
        exam.setLaboratoire(getLaboratoire());
        return exam;
    }

    private Laboratoire getLaboratoire() {
        Laboratoire laboratoire = new Laboratoire();
        laboratoire.setCode("01");
        laboratoire.setDesignation("Lab ONE");
        return laboratoire;
    }
}
