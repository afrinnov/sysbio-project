package org.afrinnov.rnd.afrinnovdgs.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "u_access_group")
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class AccessGroupEntity extends AbstractSysbioEntity {
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private String code;

    @ManyToMany
    @JoinTable(name = "u_access_right_group", joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "right_id"))
    private Set<AccessRightEntity> accessRights = new HashSet<>();

}
