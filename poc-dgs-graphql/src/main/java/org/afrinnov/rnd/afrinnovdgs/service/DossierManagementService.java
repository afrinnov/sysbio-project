package org.afrinnov.rnd.afrinnovdgs.service;


import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.*;
import org.afrinnov.rnd.afrinnovdgs.exam.id.LaboratoireId;
import org.afrinnov.rnd.afrinnovdgs.service.dto.DossierId;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DossierManagementService {
    Dossier getDossier(String dossierId);

    Patient getPatient(DossierId dossierId);

    Prescripteur getPrescripteur(DossierId dossierId);

    List<DossierExam> getDossierExam(DossierId dossierId);

    List<Exam> getExams(LaboratoireId laboratoireId, Operation operation, Pageable pageable);
}
