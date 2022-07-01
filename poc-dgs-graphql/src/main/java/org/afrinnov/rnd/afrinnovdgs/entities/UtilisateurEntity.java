package org.afrinnov.rnd.afrinnovdgs.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author ngos
 *
 */
@Entity
@Table(name = "s_utilisateur")
@Getter
@Setter
public class UtilisateurEntity extends AbstractSysbioEntity {

    private static final long serialVersionUID = 1L;
    private String username;
    /** The email. */
    private String email;
    /** The password. */
    private String password;
    @Enumerated(EnumType.STRING)
    private UserStatusType status;
    private String nomPrenom;

    @ManyToOne
    private AccessGroupEntity group;
}
