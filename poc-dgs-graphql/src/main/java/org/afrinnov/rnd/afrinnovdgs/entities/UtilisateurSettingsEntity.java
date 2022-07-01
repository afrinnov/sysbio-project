package org.afrinnov.rnd.afrinnovdgs.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "u_settings_user")
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class UtilisateurSettingsEntity extends AbstractAuditingEntity {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @Lob
    private String content;
    private String referencePhoto;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id",referencedColumnName = "id", columnDefinition = "id")
    private UtilisateurEntity utilisateur;

}
