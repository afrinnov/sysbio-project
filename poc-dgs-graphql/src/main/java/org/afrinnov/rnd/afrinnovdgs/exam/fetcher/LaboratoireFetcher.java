package org.afrinnov.rnd.afrinnovdgs.exam.fetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.DgsConstants;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Laboratoire;
import org.afrinnov.rnd.afrinnovdgs.exam.fetcher.service.LaboratoiresFetcherService;
import org.afrinnov.rnd.afrinnovdgs.exam.id.LaboratoireId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;

@DgsComponent
@RequiredArgsConstructor
public class LaboratoireFetcher {
    private final LaboratoiresFetcherService fetcherService;

    @DgsQuery(field = DgsConstants.QUERY.GetExamsFamily)
    public List<Laboratoire> getLaboratoires(@InputArgument("code") String code,
                                             @InputArgument("page") Integer page,
                                             @InputArgument("size") Integer size) {
        if (nonNull(code)) {
            return this.fetcherService.getLaboratoire(LaboratoireId.of(code)).map(List::of)
                    .orElseGet(Collections::emptyList);
        }

        if (isNull(page) && isNull(size)) {
            return fetcherService.getLaboratoires(Pageable.unpaged());
        }

        Pageable pageable = PageRequest.of(ofNullable(page).orElse(0),
                ofNullable(size).orElse(10));
        return fetcherService.getLaboratoires(pageable);
    }
}
