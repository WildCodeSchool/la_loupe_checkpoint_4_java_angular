package fr.wcs.dixheures.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.wcs.dixheures.back.entities.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {

}
