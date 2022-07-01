package org.afrinnov.rnd.afrinnovdgs.service;

import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.repository.PatientRepository;
import org.afrinnov.rnd.afrinnovdgs.repository.PrescriberRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrescriberService {
    private final PrescriberRepository prescriberRepository;
}
