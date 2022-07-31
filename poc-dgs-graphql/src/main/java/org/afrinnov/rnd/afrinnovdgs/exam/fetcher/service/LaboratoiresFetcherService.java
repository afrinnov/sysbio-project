package org.afrinnov.rnd.afrinnovdgs.exam.fetcher.service;

import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Laboratoire;
import org.afrinnov.rnd.afrinnovdgs.exam.id.LaboratoireId;
import org.afrinnov.rnd.afrinnovdgs.exam.mapper.LaboratoireMapper;
import org.afrinnov.rnd.afrinnovdgs.exam.repository.LaboratoireRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@RequiredArgsConstructor
public class LaboratoiresFetcherService {
    private final LaboratoireRepository laboratoireRepository;
    private final LaboratoireMapper laboratoireMapper;


    public List<Laboratoire> getLaboratoires(Pageable pageable) {
        return laboratoireRepository.findAll(pageable)
                .stream().map(laboratoireMapper::entityToDgs)
                .collect(toUnmodifiableList());
    }

    public Optional<Laboratoire> getLaboratoire(LaboratoireId id) {
        return laboratoireRepository.findOnByCode(id.getCode())
                .map(laboratoireMapper::entityToDgs);

    }
}
