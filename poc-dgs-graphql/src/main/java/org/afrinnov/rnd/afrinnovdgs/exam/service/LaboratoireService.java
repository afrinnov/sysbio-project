package org.afrinnov.rnd.afrinnovdgs.exam.service;

import lombok.RequiredArgsConstructor;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Exam;
import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Operation;
import org.afrinnov.rnd.afrinnovdgs.entities.ExamenEntity;
import org.afrinnov.rnd.afrinnovdgs.entities.LaboratoireEntity;
import org.afrinnov.rnd.afrinnovdgs.exam.id.LaboratoireId;
import org.afrinnov.rnd.afrinnovdgs.exam.repository.ExamRepository;
import org.afrinnov.rnd.afrinnovdgs.exam.repository.ExamenFormulaireRepository;
import org.afrinnov.rnd.afrinnovdgs.exam.repository.LaboratoireRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toUnmodifiableList;

@Service
@RequiredArgsConstructor
public class LaboratoireService {
    private final ExamRepository examRepository;
    private final LaboratoireRepository laboratoireRepository;
    private final ExamenFormulaireRepository formulaireRepository;

    public List<Exam> getExams(LaboratoireId laboratoireId, Operation operation, Pageable pageable) {
        LaboratoireEntity laboratoire = laboratoireRepository.findOnByCode(laboratoireId.getCode()).orElseThrow();
        if (Objects.nonNull(operation)) {
            if (Operation.NON_FORM.equals(operation)) {
                return formulaireRepository.getExamsWithoutForm(laboratoire, pageable)
                        .stream()
                        .map(ex->mapToDgs(ex, Boolean.FALSE))
                        .collect(toUnmodifiableList());
            }

            if (Operation.WITH_FORM.equals(operation)) {
                return formulaireRepository.getExamsWithForm(laboratoire, pageable)
                        .stream()
                        .map(ex->mapToDgs(ex, null))
                        .collect(toUnmodifiableList());
            }
        }
        Specification<ExamenEntity> specification = makeExamenSpecification(laboratoireId);
        return examRepository.findAll(specification, pageable)
                .stream()
                .map(entity -> mapToDgs(entity, Boolean.TRUE))
                .collect(toUnmodifiableList());
    }

    private Specification<ExamenEntity> makeExamenSpecification(LaboratoireId laboratoireId) {
        return (root, query, builder) -> builder.equal(root.<LaboratoireEntity>get("laboratoire").get("code"),
                laboratoireId.getCode());
    }

    private Exam mapToDgs(ExamenEntity entity, Boolean hasForm) {
        return Exam.newBuilder()
                .code(entity.getCode())
                .description(entity.getDescription())
                .designation(entity.getDesignation())
                .prix(entity.getPrix())
                .prixPartenaire(entity.getPrixPartenaire())
                .prixUrgent(entity.getPrixUrgent())
                .hasForm(hasForm)
                .build();
    }
}
