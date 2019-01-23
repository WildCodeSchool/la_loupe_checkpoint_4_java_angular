package com.wildcodeschool.playlist.playlist.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.playlist.playlist.entities.Playlist;

@Repository
public interface PlaylistRespository extends JpaRepository<Playlist, Long>{

}
