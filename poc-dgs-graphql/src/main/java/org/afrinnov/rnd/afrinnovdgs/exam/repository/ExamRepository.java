package org.afrinnov.rnd.afrinnovdgs.exam.repository;

import org.afrinnov.rnd.afrinnovdgs.entities.ExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExamRepository extends JpaRepository<ExamenEntity, Long>, JpaSpecificationExecutor<ExamenEntity> {

}
