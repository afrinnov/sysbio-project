package org.afrinnov.rnd.afrinnovdgs.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.DgsConstants;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Dossier;
import org.afrinnov.rnd.afrinnovdgs.service.DossierManagementService;

;

@DgsComponent
@RequiredArgsConstructor
public class DossiersFetcher {
    private final DossierManagementService dossierManagementService;

    @DgsQuery(field = DgsConstants.QUERY.Dossiers)
    public Dossier getDossier(@InputArgument String dossierId) {
        return dossierManagementService.getDossier(dossierId);
    }
}
