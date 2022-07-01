package org.afrinnov.rnd.afrinnovdgs.service.mapper;

import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Dossier;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.DossierExam;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Patient;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Prescripteur;
import org.afrinnov.rnd.afrinnovdgs.entities.DossierEntity;
import org.afrinnov.rnd.afrinnovdgs.entities.DossierExamenEntity;
import org.afrinnov.rnd.afrinnovdgs.entities.PatientEntity;
import org.afrinnov.rnd.afrinnovdgs.entities.PrescripteurEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DossierMapper {

    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "prescripteur", ignore = true)
    @Mapping(target = "examens", ignore = true)
    Dossier entityToDgs(DossierEntity entity);

    Patient entityToDgs(PatientEntity entity);

    @Mapping(target = "name", source = "nomPrenom")
    @Mapping(target = "email", source = "addressEmail")
    @Mapping(target = "title", source = "titre")
    @Mapping(target = "currentQuotePart", source = "quotePart")
    Prescripteur entityToDgs(PrescripteurEntity entity);

    @Mapping(target = "dossierRef", source = "dossier.code")
    DossierExam entityToDgs(DossierExamenEntity entity);
}
