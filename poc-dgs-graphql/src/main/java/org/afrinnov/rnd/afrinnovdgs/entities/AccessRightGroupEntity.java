package org.afrinnov.rnd.afrinnovdgs.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "u_access_right_group")
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class AccessRightGroupEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AccessGroupEntity group;
    @ManyToOne
    private AccessRightEntity right;

    public AccessRightGroupEntity(AccessGroupEntity group, AccessRightEntity right) {
        this.group = group;
        this.right = right;
    }
}
