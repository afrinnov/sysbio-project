package org.afrinnov.rnd.afrinnovdgs.service;

import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.entities.DossierExamenEntity;
import org.afrinnov.rnd.afrinnovdgs.repository.DossierExamRepository;
import org.afrinnov.rnd.afrinnovdgs.service.dto.DossierId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DossierExamService {
    private final DossierExamRepository dossierExamRepository;

    public List<DossierExamenEntity> getExams(DossierId dossierId) {
        return dossierExamRepository.findAllByDossier_code(dossierId.getId());
    }
}
