package org.afrinnov.rnd.afrinnovdgs.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 * @author alexk
 */
@Entity
@Table(name = "d_dossier_examen")
@Setter
@Getter
public class DossierExamenEntity extends AbstractSysbioEntity{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "amount")
    private  double amount;

    @ManyToOne
    private DossierEntity dossier;
    
    @ManyToOne
    private ExamenEntity examen;
    private String content;
    private String author;
    @Enumerated(EnumType.STRING)
    private SaisiExamenStatus status;
    private Integer realHeight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DossierExamenEntity that = (DossierExamenEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
