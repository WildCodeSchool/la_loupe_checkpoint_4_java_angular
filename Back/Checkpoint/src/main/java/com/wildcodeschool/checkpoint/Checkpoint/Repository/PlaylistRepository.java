package com.wildcodeschool.checkpoint.Checkpoint.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildcodeschool.checkpoint.Checkpoint.Entity.Playlist;

public interface PlaylistRepository  extends JpaRepository<Playlist, Long>{

}
