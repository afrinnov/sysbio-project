package org.afrinnov.rnd.afrinnovdgs.repository;

import org.afrinnov.rnd.afrinnovdgs.entities.DossierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DossierRepository extends JpaRepository<DossierEntity, Long> {
    Optional<DossierEntity> findOneByCode(String dossierId);
}
