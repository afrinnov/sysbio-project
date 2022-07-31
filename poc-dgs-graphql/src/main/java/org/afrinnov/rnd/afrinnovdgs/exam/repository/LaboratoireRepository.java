package org.afrinnov.rnd.afrinnovdgs.exam.repository;

import org.afrinnov.rnd.afrinnovdgs.entities.LaboratoireEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LaboratoireRepository extends JpaRepository<LaboratoireEntity, Long> {
    Optional<LaboratoireEntity> findOnByCode(String code);
}
