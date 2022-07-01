package org.afrinnov.rnd.afrinnovdgs.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.DgsConstants;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Dossier;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Patient;
import org.afrinnov.rnd.afrinnovdgs.service.DossierManagementService;
import org.afrinnov.rnd.afrinnovdgs.service.dto.DossierId;

@DgsComponent
@RequiredArgsConstructor
public class PatientsFetcher {
    private final DossierManagementService dossierManagementService;


    @DgsData(parentType = DgsConstants.DOSSIER.TYPE_NAME, field = DgsConstants.DOSSIER.Patient)
    public Patient getPatient(DataFetchingEnvironment dataFetchingEnvironment) {
        Dossier dossier=dataFetchingEnvironment.getSource();
        return dossierManagementService.getPatient(DossierId.of(dossier.getCode()));
    }
}
