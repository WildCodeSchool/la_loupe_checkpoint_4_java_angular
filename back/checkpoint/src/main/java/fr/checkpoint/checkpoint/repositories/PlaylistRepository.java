package fr.checkpoint.checkpoint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.checkpoint.checkpoint.entities.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

}
