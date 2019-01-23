package fr.songlist.checkpoint.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.songlist.checkpoint.entities.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}
