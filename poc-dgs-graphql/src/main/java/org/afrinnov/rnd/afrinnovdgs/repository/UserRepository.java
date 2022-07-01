package org.afrinnov.rnd.afrinnovdgs.repository;

import org.afrinnov.rnd.afrinnovdgs.entities.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UtilisateurEntity, Long> {
    @Query("SELECT user FROM UtilisateurEntity user WHERE user.email = :email OR user.username = :email")
    Optional<UtilisateurEntity> findOneByEmailOrUsername(String email);
}
