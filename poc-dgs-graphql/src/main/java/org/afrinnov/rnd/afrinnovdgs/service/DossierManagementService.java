package org.afrinnov.rnd.afrinnovdgs.service;


import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Dossier;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.DossierExam;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Patient;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Prescripteur;
import org.afrinnov.rnd.afrinnovdgs.service.dto.DossierId;

import java.util.List;

public interface DossierManagementService {
    Dossier getDossier(String dossierId);

    Patient getPatient(DossierId dossierId);

    Prescripteur getPrescripteur(DossierId dossierId);

    List<DossierExam> getDossierExam(DossierId dossierId);

}
