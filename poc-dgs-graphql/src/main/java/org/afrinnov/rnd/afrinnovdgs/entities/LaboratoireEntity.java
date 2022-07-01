package org.afrinnov.rnd.afrinnovdgs.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ngos
 *
 */
@Entity
@Table(name = "c_laboratoire")
@Getter
@Setter
public class LaboratoireEntity extends AbstractSysbioEntity{
	private static final long serialVersionUID = 1L;
	private  String code;
	private String designation;
	private  String description;
	private String responsable;
	private  String emailResponsable;

	@OneToMany(
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "laboratoire"
	)
	private Set<ExamenEntity> examens = new HashSet<>();
}
