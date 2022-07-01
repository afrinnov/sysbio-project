package org.afrinnov.rnd.afrinnovdgs.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

/**
 * @author alexk
 */
@Entity
@Table(name = "d_dossier")
@Setter
@Getter
@ToString
public class DossierEntity extends AbstractSysbioEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "code")
    private String code;
    @Column(name = "patient_type")
    @Enumerated(EnumType.STRING)
    private PatientType patientType;
    @Column(name = "entry_date")
    private OffsetDateTime entryDate;
    private double amountToPay;
    private double receiveAmount;
    private double restAmount;
    private String author;
    private double percent;
    @ManyToOne
    private PatientEntity patient;
    @ManyToOne
    private PrescripteurEntity prescripteur;

    private Double quotePart;
    private Double amountToRepay;
    @Enumerated(EnumType.STRING)
    private SaisiDossierStatus saisiStatus;
    private LocalDateTime readyToPrintDate;
    private LocalDateTime saisieDate;
    @Enumerated(EnumType.STRING)
    private EmergencyMode emergencyMode;


}
