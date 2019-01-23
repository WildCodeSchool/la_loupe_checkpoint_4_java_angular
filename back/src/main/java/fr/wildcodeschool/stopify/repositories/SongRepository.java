package fr.wildcodeschool.stopify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.wildcodeschool.stopify.entities.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

}
