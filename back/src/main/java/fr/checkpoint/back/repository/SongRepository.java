package fr.checkpoint.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.checkpoint.back.entities.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>{

}
