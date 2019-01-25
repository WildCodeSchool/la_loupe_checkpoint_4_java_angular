package com.PlaylistWild.PlaylistWild.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PlaylistWild.PlaylistWild.entities.PlaylistWild;

@Repository
public interface PlaylistWildDAO extends JpaRepository<PlaylistWild, Long> {

	List<PlaylistWild> findByNameContainingOrArtistContainingOrAlbumContainingOrImgContaining(String name,
			String artist, String album, String img);

}