package com.checkpoint.last.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.checkpoint.last.entities.Song;

@Repository
public interface SongRepo extends JpaRepository<Song, Long>{

}
