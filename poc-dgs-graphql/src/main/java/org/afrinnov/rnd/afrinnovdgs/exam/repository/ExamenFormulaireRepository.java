package org.afrinnov.rnd.afrinnovdgs.exam.repository;

import org.afrinnov.rnd.afrinnovdgs.entities.ExamenEntity;
import org.afrinnov.rnd.afrinnovdgs.entities.ExamenFormulaireEntity;
import org.afrinnov.rnd.afrinnovdgs.entities.LaboratoireEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface ExamenFormulaireRepository extends JpaRepository<ExamenFormulaireEntity, Long>,
        JpaSpecificationExecutor<ExamenFormulaireEntity> {
    @Query("SELECT exam FROM ExamenFormulaireEntity form LEFT JOIN form.examen exam WHERE exam.laboratoire = ?1")
    List<ExamenEntity> getExamsWithForm(LaboratoireEntity laboratoire, Pageable pageable);

    @Query("SELECT exam FROM ExamenFormulaireEntity form RIGHT JOIN form.examen exam WHERE exam.laboratoire = ?1 " +
            " AND form.examen IS NULL")
    List<ExamenEntity> getExamsWithoutForm(LaboratoireEntity laboratoire, Pageable pageable);
}
