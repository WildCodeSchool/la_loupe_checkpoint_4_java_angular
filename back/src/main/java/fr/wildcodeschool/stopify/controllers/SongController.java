package fr.wildcodeschool.stopify.controllers;

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

import fr.wildcodeschool.stopify.entities.Song;
import fr.wildcodeschool.stopify.repositories.SongRepository;

@RestController
@CrossOrigin(origins = "*")
public class SongController {

	@Autowired
	SongRepository songRepository;
	
	// Add a song
	@PostMapping(path = "/api/song")
	public Song addSong(@RequestBody Song p_song) throws Exception {
		
		try {
			if (
				p_song.getName() != null &&
				p_song.getArtist() != null &&
				p_song.getAlbum() != null &&
				p_song.getImg() != null
			) {
				return songRepository.save(p_song);
			} else {
				throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST,
					"Missing data"
				);
			}
		} catch(Exception e) {
			throw new ResponseStatusException(
				HttpStatus.BAD_REQUEST,
				"Cannot add the song"
			);
		} 
		
	}
	
	// Modify a song
	@PutMapping(path = "/api/song/{id}")
	public Song updateSong(@PathVariable("id") Long p_id, @RequestBody Song p_song) throws Exception {
		
		try {
			Song currentSong = songRepository.findById(p_id).get();
			if (p_song.getName() != null) {
				currentSong.setName(p_song.getName());				
			}
			if (p_song.getArtist() != null) {
				currentSong.setArtist(p_song.getArtist());
			}
			if (p_song.getAlbum() != null) {
				currentSong.setAlbum(p_song.getAlbum());
			}
			return songRepository.save(currentSong);
		} catch(Exception e) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND,
				"Cannot find the song"
			);
		}
	}
	
	// Delete a song
	@DeleteMapping(path = "/api/song/{id}")
	public boolean deleteSong(@PathVariable("id") Long p_id) throws Exception {
		
		try {
			songRepository.deleteById(p_id);
			return true;
		} catch(Exception e) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND,
				"Cannot find the song"
			);
		}
	}
	
	// List all songs
	@GetMapping(path= "/api/songs")
	public List<Song> listAllSongs() throws Exception {
		try {
			return songRepository.findAll();
		} catch(Exception e) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND,
				"Cannot find songs"
			);
		}
	}
	
}
	
