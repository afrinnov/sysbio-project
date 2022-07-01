package org.afrinnov.rnd.afrinnovdgs.repository;

import org.afrinnov.rnd.afrinnovdgs.entities.DossierExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DossierExamRepository extends JpaRepository<DossierExamenEntity, Long> {
    List<DossierExamenEntity> findAllByDossier_code(String dossierId);
}
