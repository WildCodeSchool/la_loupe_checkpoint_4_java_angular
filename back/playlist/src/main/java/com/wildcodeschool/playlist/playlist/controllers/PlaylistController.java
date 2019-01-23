package com.wildcodeschool.playlist.playlist.controllers;

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

import com.wildcodeschool.playlist.playlist.entities.Playlist;
import com.wildcodeschool.playlist.playlist.respositories.PlaylistRespository;

@CrossOrigin(origins ="*")
@RestController
public class PlaylistController {
	
	@Autowired
	PlaylistRespository playRespo;
	
	@GetMapping("/playlists")
	public List<Playlist>index(){
		return playRespo.findAll();
	}
	
	@GetMapping("/playlists/{id}")
	public Playlist getById(@PathVariable ("id") Long p_id) throws Exception{
	
		try {
			return playRespo.findById(p_id).get();
		}
		catch (Exception p_exception) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"pas de chanson avec l'id: " + p_id					
					);
		}
	}

	
	@PostMapping("/playlists")
	public Playlist create(@RequestBody Playlist playl) {
		return playRespo.save(playl);
	}
	
	@PutMapping("/playlists/{id}")
	public Playlist update(@PathVariable ("id")Long p_id, @RequestBody Playlist playl) throws Exception {
		
		try {
			
			Playlist current = playRespo.findById(p_id).get();
			
			if (playl.getName() != "") {
				current.setName(playl.getName());
			}
			
			if (playl.getArtist() != "") {
				current.setArtist(playl.getArtist());
			}
			
			if (playl.getAlbum() != "") {
				current.setAlbum(playl.getAlbum());
			}
			
			if (playl.getImg() != "") {
				current.setImg(playl.getImg());
			}
			
			return playRespo.save(current);		
		}
		catch (Exception p_execption) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"pas de chanson avec l'id: " + p_id	
					);
			
		}
		
	}
	
	@DeleteMapping("/playlists/{id}")
	public boolean delete(@PathVariable ("id") Long p_id) throws Exception {
		try {
			playRespo.deleteById(p_id);
			return true;
		}
		catch (Exception p_exceotion){
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"pas de chanson avec l'id: " + p_id	
					);
		}
	}
	
	

}
