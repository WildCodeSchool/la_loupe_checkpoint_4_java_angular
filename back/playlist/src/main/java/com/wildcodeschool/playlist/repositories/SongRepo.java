package com.wildcodeschool.playlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildcodeschool.playlist.entities.Song;

public interface SongRepo extends JpaRepository<Song, Long> {

}
