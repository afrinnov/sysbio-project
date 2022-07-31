package org.afrinnov.rnd.afrinnovdgs.exam.fetcher.service;

import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.FormatType;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Formulaire;
import org.afrinnov.rnd.afrinnovdgs.entities.ExamenEntity;
import org.afrinnov.rnd.afrinnovdgs.entities.ExamenFormulaireEntity;
import org.afrinnov.rnd.afrinnovdgs.exam.id.ExamId;
import org.afrinnov.rnd.afrinnovdgs.exam.repository.ExamenFormulaireRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamenFormulaireFetcherService {
    private final ExamenFormulaireRepository formulaireRepository;

    public List<Formulaire> getFormulaires(ExamId id, FormatType formatType) {
        return formulaireRepository.findAll(makeFormulaireSpecification(id, formatType))
                .stream()
                .map(this::mapForm)
                .collect(Collectors.toUnmodifiableList());
    }

    private Formulaire mapForm(ExamenFormulaireEntity entity) {
        return Formulaire.newBuilder()
                .content(entity.getContent())
                .designation(entity.getDesignation())
                .format(translateFormType(entity))
                .groupe(entity.getGroupe())
                .ordre(entity.getOrdre())
                .build();
    }

    private FormatType translateFormType(ExamenFormulaireEntity entity) {
        return Optional.ofNullable(entity.getFormatType())
                .map(Enum::name)
                .map(FormatType::valueOf).orElse(null);
    }

    private Specification<ExamenFormulaireEntity> makeFormulaireSpecification(ExamId examId, FormatType formatType) {

        return (root, query, builder) -> {
            Predicate examCodeEqual = builder.equal(root.<ExamenEntity>get("examen").get("code"),
                    examId.getCode());
            if (Objects.isNull(formatType)) {
                return examCodeEqual;
            }
            return builder.and(examCodeEqual, builder.equal(root.get("formatType"), formatType));
        };
    }
}
