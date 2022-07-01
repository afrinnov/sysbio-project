package org.afrinnov.rnd.afrinnovdgs.repository;

import org.afrinnov.rnd.afrinnovdgs.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
}
