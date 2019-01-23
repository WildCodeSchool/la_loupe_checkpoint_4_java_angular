package com.wildcodeschool.checkpoint.Checkpoint.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wildcodeschool.checkpoint.Checkpoint.Entity.Playlist;
import com.wildcodeschool.checkpoint.Checkpoint.Repository.PlaylistRepository;


@CrossOrigin(origins="*")
@RestController
public class PlaylistController {
		
	@Autowired
	PlaylistRepository playRepo;
	
	@GetMapping("/playlists")
	public List <Playlist>getAll(){
		return playRepo.findAll();
	}

	
	@GetMapping("/playlists/{id}")
	
	public Playlist show(@PathVariable("id")Long p_id ) throws Exception {
		try {
			return playRepo.findById(p_id).get();
		}
		catch (Exception p_exception) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"Pas de music trouver par son id" + p_id
			);
		}
		
	}
	
	@PostMapping ("/playlists")
	public Playlist create(@RequestBody Playlist play) {
		return playRepo.save(play);
	}
	
	@PutMapping ("/playlists/{id}")
		public Playlist update(@PathVariable("id") Long p_id , @RequestBody Playlist play) {
			try {
				Playlist current = playRepo.findById(p_id).get();
				
				if(play.getName() != null && play.getName() != "") {
					current.setName(play.getName());
				}
				if(play.getArtist() != null && play.getArtist() != "") {
					current.setArtist(play.getArtist());
				}
				if(play.getAlbum() != null && play.getAlbum() != "") {
					current.setAlbum(play.getAlbum());
				}
				if(play.getImg() != null && play.getImg() != "") {
					current.setImg(play.getImg());
				}
				return playRepo.save(current);
				
			}catch (Exception p_exception) {
				throw new ResponseStatusException(
						HttpStatus.NOT_FOUND, 
					    "pas de music trouver par son id " + p_id);
				
			}
		}
	
	@DeleteMapping("/playlists/{id}")
	
		public boolean delete(@PathVariable ("id") Long p_id ) {
		
			try {
				playRepo.deleteById(p_id);
				return true;
			}catch
				(Exception p_exception){
					throw new ResponseStatusException(
							 HttpStatus.NOT_FOUND, 
					          "pas de music trouver par son id" +  p_id);
				}
			
	}
	
	
	
}
