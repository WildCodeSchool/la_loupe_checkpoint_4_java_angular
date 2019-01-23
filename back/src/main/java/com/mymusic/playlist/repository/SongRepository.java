package com.mymusic.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymusic.playlist.entities.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>{

}
