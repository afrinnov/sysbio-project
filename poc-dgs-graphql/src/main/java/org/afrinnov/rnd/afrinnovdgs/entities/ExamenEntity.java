package org.afrinnov.rnd.afrinnovdgs.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "c_examen")
@Setter
@Getter
public class ExamenEntity extends AbstractSysbioEntity {
    private static final long serialVersionUID = 1L;
    @Column(name = "code")
    private  String code;

    @Column(name = "designation")
    private String designation;

    @Column(name = "description", columnDefinition = "text default ''")
    private  String description;

    @Column(name = "prix_urgence")
    private Double prixUrgent;

    @Column(name = "prix_partenaire")
    private Double prixPartenaire;

    @Column(name = "prix")
    private double prix;

    @ManyToOne
    @JoinColumn(name = "laboratoire_id", referencedColumnName = "id")
    private LaboratoireEntity laboratoire;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ExamenEntity that = (ExamenEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
