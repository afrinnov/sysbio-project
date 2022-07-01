package org.afrinnov.rnd.afrinnovdgs.service;

import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.entities.DossierEntity;
import org.afrinnov.rnd.afrinnovdgs.repository.DossierRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DossierService {
    private final DossierRepository dossierRepository;

    public DossierEntity getDossier(String dossierId) {
        return dossierRepository.findOneByCode(dossierId)
                .orElseThrow();
    }
}
