package org.afrinnov.rnd.afrinnovdgs.exam.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.DgsConstants;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.*;
import org.afrinnov.rnd.afrinnovdgs.exam.fetcher.service.ExamenFormulaireFetcherService;
import org.afrinnov.rnd.afrinnovdgs.exam.id.ExamId;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class ExamenFormulaireFetcher {
    private final ExamenFormulaireFetcherService fetcherService;

    @DgsData(parentType = DgsConstants.EXAM.TYPE_NAME, field = DgsConstants.EXAM.Formulaires)
    public List<Formulaire> getLaboratoires(DataFetchingEnvironment dataFetchingEnvironment,
                                            @InputArgument("format") FormatType formatType) {
        Exam exam = dataFetchingEnvironment.getSource();
        ExamId examId = ExamId.of(exam.getCode());

        return fetcherService.getFormulaires(examId, formatType);
    }
}
