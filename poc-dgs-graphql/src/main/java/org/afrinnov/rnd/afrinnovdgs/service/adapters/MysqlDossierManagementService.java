package org.afrinnov.rnd.afrinnovdgs.service.adapters;

import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.*;
import org.afrinnov.rnd.afrinnovdgs.exam.id.LaboratoireId;
import org.afrinnov.rnd.afrinnovdgs.exam.service.LaboratoireService;
import org.afrinnov.rnd.afrinnovdgs.service.DossierExamService;
import org.afrinnov.rnd.afrinnovdgs.service.DossierManagementService;
import org.afrinnov.rnd.afrinnovdgs.service.DossierService;
import org.afrinnov.rnd.afrinnovdgs.service.dto.DossierId;
import org.afrinnov.rnd.afrinnovdgs.service.mapper.DossierMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@Primary
@RequiredArgsConstructor
public class MysqlDossierManagementService implements DossierManagementService {
    private final DossierService dossierService;
    private final DossierExamService dossierExamService;

    private final LaboratoireService laboratoireService;

    private final DossierMapper dossierMapper;

    @Override
    public Dossier getDossier(String dossierId) {
        return dossierMapper.entityToDgs(dossierService.getDossier(dossierId));
    }

    @Override
    public Patient getPatient(DossierId dossierId) {
        return dossierMapper.entityToDgs(dossierService.getDossier(dossierId.getId()).getPatient());
    }

    @Override
    public Prescripteur getPrescripteur(DossierId dossierId) {
        return dossierMapper.entityToDgs(dossierService.getDossier(dossierId.getId()).getPrescripteur());
    }

    @Override
    public List<DossierExam> getDossierExam(DossierId dossierId) {
        return dossierExamService.getExams(dossierId)
                .stream().map(dossierMapper::entityToDgs).collect(toUnmodifiableList());
    }

    @Override
    public List<Exam> getExams(LaboratoireId laboratoireId, Operation operation, Pageable pageable) {
        return laboratoireService.getExams(laboratoireId,operation, pageable);
    }
}
