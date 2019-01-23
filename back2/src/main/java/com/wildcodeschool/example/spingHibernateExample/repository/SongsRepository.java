package com.wildcodeschool.example.spingHibernateExample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildcodeschool.example.spingHibernateExample.entities.Songs;


public interface SongsRepository extends JpaRepository<Songs, Integer>{

	List<Songs> findByNameContainingOrArtistContainingOrAlbumContainingOrImgContaining(String searchTerm, String searchTerm2,
			String searchTerm3);
	
	

}
