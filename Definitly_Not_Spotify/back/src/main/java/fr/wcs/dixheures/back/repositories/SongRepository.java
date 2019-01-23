package fr.wcs.dixheures.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.wcs.dixheures.back.entities.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}
