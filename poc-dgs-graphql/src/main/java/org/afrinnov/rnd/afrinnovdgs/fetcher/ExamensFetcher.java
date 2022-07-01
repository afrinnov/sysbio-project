package org.afrinnov.rnd.afrinnovdgs.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.DgsConstants;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Dossier;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.DossierExam;
import org.afrinnov.rnd.afrinnovdgs.service.DossierManagementService;
import org.afrinnov.rnd.afrinnovdgs.service.dto.DossierId;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class ExamensFetcher {
    private final DossierManagementService dossierManagementService;

    @DgsData(parentType = DgsConstants.DOSSIER.TYPE_NAME, field = DgsConstants.DOSSIER.Examens)
    public List<DossierExam> getDossierExam(DataFetchingEnvironment dataFetchingEnvironment) {
        Dossier dossier = dataFetchingEnvironment.getSource();
        return dossierManagementService.getDossierExam(DossierId.of(dossier.getCode()));
    }
}
