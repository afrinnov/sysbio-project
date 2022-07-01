package org.afrinnov.rnd.afrinnovdgs.service;

import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.entities.DossierEntity;
import org.afrinnov.rnd.afrinnovdgs.entities.PatientEntity;
import org.afrinnov.rnd.afrinnovdgs.repository.DossierRepository;
import org.afrinnov.rnd.afrinnovdgs.service.dto.DossierId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final DossierRepository patientRepository;

    public PatientEntity getPatient(DossierId dossierId) {
        return patientRepository.findOneByCode(dossierId.getId())
                .map(DossierEntity::getPatient)
                .orElseThrow();
    }
}
