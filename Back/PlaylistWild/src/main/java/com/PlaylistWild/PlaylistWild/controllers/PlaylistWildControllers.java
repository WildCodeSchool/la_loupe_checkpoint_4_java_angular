package com.PlaylistWild.PlaylistWild.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.PlaylistWild.PlaylistWild.entities.PlaylistWild;
import com.PlaylistWild.PlaylistWild.repositories.PlaylistWildDAO;


@CrossOrigin(origins="*")
@RestController
public class PlaylistWildControllers {
	
		@Autowired
		PlaylistWildDAO playlistRepo;
		
		@GetMapping("/playlistwilds")
		public List<PlaylistWild> index() {
			return playlistRepo.findAll();			
		}
		
		@GetMapping("/playlistwilds/{id}")
		public PlaylistWild show(@PathVariable Long id) {
			return playlistRepo.findById(id).get();
		}
		
		@PostMapping("/playlistwilds/search")
		public List<PlaylistWild> search(@RequestBody Map<String, String> body){
	        String searchTerm = body.get("text");
	        return playlistRepo.findByNameContainingOrArtistContainingOrAlbumContainingOrImgContaining(searchTerm, searchTerm, searchTerm, searchTerm);
	    }
		
		@PostMapping("/playlistwilds")
		public PlaylistWild create(@RequestBody PlaylistWild playlistWild) {
			return playlistRepo.save(playlistWild);
		}
		
		@PutMapping("/playlistwilds/{id}")
		public PlaylistWild update(@PathVariable Long id, @RequestBody PlaylistWild playlistWild) {
			PlaylistWild playlistWildToUpdate = playlistRepo.findById(id).get();
			playlistWildToUpdate.setName(playlistWild.getName());
			playlistWildToUpdate.setArtist(playlistWild.getArtist());
			playlistWildToUpdate.setAlbum(playlistWild.getAlbum());
			playlistWildToUpdate.setImg(playlistWild.getImg());
			
			return playlistRepo.save(playlistWildToUpdate);

		}
		
		@DeleteMapping("playlistwilds/{id}")
		public boolean delete(@PathVariable Long id) {
			playlistRepo.deleteById(id);
			return true;
		}
		
		

}
