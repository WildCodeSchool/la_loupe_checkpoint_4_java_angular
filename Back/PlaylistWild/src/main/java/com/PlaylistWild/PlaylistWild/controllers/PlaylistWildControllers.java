package com.PlaylistWild.PlaylistWild.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PlaylistWild.PlaylistWild.entities.PlaylistWild;
import com.PlaylistWild.PlaylistWild.repositories.PlaylistWildDAO;



@RestController
@RequestMapping("/playlistwild")
public class PlaylistWildControllers {
	
		@Autowired
		PlaylistWildDAO playlistRepo;
		
		@GetMapping("/create")
		public PlaylistWild createPlaylistWild(String name, String artist, String album, String img) {
			PlaylistWild playlistwild = new PlaylistWild (name, artist, album, img);
			return playlistRepo.save(playlistwild);
		}
		
		@GetMapping("/search")
		public PlaylistWild getPlaylistWild(long playlistWildId) {
			return playlistRepo.findById(playlistWildId).get();
		}
		
		@GetMapping("/all")
		public List<PlaylistWild> getAllPlaylistWilds() {
			return playlistRepo.findAll();			
		}
		
		@PutMapping("/update")
		public PlaylistWild updateBook(Long playlistWildId, String name, String artist, String album, String img) {
			PlaylistWild playlistWildToUpdate = playlistRepo.findById(playlistWildId).get();
			if(name!=null) {
				playlistWildToUpdate.setName(name);
			}
			if(artist!=null) {
				playlistWildToUpdate.setArtist(artist);
			}
			if(album!=null) {
				playlistWildToUpdate.setAlbum(album);
			}
			if(img!=null) {
				playlistWildToUpdate.setImg(img);
			}
			return playlistRepo.save(playlistWildToUpdate);
			
		}
		
		@DeleteMapping("/delete")
		public void deleteBook(Long id) {
			playlistRepo.deleteById(id);
		}
		
		

}
