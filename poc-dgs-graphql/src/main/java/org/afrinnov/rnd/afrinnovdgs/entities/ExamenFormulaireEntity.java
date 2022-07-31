/**
 * 
 */
package org.afrinnov.rnd.afrinnovdgs.entities;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ngos
 *
 */
@Entity
@Table(name = "c_examen_formulaire")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ExamenFormulaireEntity extends AbstractSysbioEntity{
    private static final long serialVersionUID = 1L;
    @ManyToOne(fetch = FetchType.LAZY)
	private ExamenEntity examen;
	private String content;
	@Enumerated(EnumType.STRING)
	private FormatType formatType;
	private String ordre;	
	private String designation;
	private String groupe;

}
