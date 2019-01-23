package com.eTunes.eTunes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eTunes.eTunes.entities.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>{

}
