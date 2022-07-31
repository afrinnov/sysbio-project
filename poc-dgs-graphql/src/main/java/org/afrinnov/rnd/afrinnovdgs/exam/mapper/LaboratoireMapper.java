package org.afrinnov.rnd.afrinnovdgs.exam.mapper;

import org.afrinnov.rnd.afrinnovdgs.datafetcher.types.Laboratoire;
import org.afrinnov.rnd.afrinnovdgs.entities.LaboratoireEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LaboratoireMapper {

    @Mapping(target = "exams", ignore = true)
    Laboratoire entityToDgs(LaboratoireEntity laboratoire);

    @Mapping(target = "examens", ignore = true)
    LaboratoireEntity dgsToEntity(Laboratoire laboratoire);

}
