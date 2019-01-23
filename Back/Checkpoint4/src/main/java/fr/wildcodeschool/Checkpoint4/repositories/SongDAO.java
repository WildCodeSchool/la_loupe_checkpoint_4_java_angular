package fr.wildcodeschool.Checkpoint4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.wildcodeschool.Checkpoint4.entities.Song;

@Repository
public interface SongDAO extends JpaRepository<Song, Long> {

}
