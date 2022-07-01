/**
 *
 */
package org.afrinnov.rnd.afrinnovdgs.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author ngos
 *
 */
@Entity
@Table(name = "s_prescripteur")
@Setter
@Getter
public class PrescripteurEntity extends AbstractSysbioEntity {
    private static final long serialVersionUID = 1L;
    private String matricule;
    private String nomPrenom;
    private String addressEmail;
    private String phone;
    private String titre;
    private String service;
    private double quotePart;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PrescripteurEntity that = (PrescripteurEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
