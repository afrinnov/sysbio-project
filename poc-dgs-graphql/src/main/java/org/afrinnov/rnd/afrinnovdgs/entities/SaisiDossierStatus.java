package org.afrinnov.rnd.afrinnovdgs.entities;

import lombok.Getter;

/**
 * @author devalgas kamga on 03/06/2020. 00:25
 */
@Getter
public enum SaisiDossierStatus {
    SAVED, PENDING_TO_VALIDATE,
    READY_TO_PRINT, PRINTED,
    READY_TO_EDIT;

}
