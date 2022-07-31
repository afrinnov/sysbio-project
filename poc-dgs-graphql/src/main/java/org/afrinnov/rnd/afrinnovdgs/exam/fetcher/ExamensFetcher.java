package org.afrinnov.rnd.afrinnovdgs.exam.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.DgsConstants;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.*;
import org.afrinnov.rnd.afrinnovdgs.exam.id.LaboratoireId;
import org.afrinnov.rnd.afrinnovdgs.service.DossierManagementService;
import org.afrinnov.rnd.afrinnovdgs.service.dto.DossierId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;

@DgsComponent
@RequiredArgsConstructor
public class ExamensFetcher {
    private final DossierManagementService dossierManagementService;

    @DgsData(parentType = DgsConstants.DOSSIER.TYPE_NAME, field = DgsConstants.DOSSIER.Examens)
    public List<DossierExam> getDossierExam(DataFetchingEnvironment dataFetchingEnvironment) {
        Dossier dossier = dataFetchingEnvironment.getSource();
        return dossierManagementService.getDossierExam(DossierId.of(dossier.getCode()));
    }

    @DgsData(parentType = DgsConstants.LABORATOIRE.TYPE_NAME, field = DgsConstants.LABORATOIRE.Exams)
    public List<Exam> getExamsOfLaboratoire(DataFetchingEnvironment dataFetchingEnvironment,
                                            @InputArgument("page")Integer page,
                                            @InputArgument("size")Integer size,
                                            @InputArgument("operation") Operation operation) {
        Laboratoire laboratoire = dataFetchingEnvironment.getSource();
        if(Boolean.logicalAnd(Objects.isNull(page), Objects.isNull(size))) {
            return dossierManagementService.getExams(LaboratoireId.of(laboratoire.getCode()), operation, Pageable.unpaged());
        }
        Pageable pageable=PageRequest.of(page, size);
        return dossierManagementService.getExams(LaboratoireId.of(laboratoire.getCode()), operation, pageable);
    }
}
