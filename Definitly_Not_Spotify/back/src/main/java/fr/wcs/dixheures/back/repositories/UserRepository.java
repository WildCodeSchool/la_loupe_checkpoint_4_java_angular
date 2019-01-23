package fr.wcs.dixheures.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.wcs.dixheures.back.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByNameAndPassword(String name, String password);
}
