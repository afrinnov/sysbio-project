package org.afrinnov.rnd.afrinnovdgs.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author alexk
 */
@Entity
@Table(name = "s_patient")
@Setter
@Getter
public class PatientEntity extends AbstractSysbioEntity {

    private static final long serialVersionUID = 1L;
    @Column(name = "code")
    private String code;
    @Column(name = "name_subname")
    private String name;
    //    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    @Column(name = "email")
    private String email;
    @Column(name = "sexe")
    private String sex;

    @Column(name = "age")
    private String age;
    @Column(name = "contact")
    private String contact;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PatientEntity that = (PatientEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
