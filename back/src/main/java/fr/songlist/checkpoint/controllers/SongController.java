package fr.songlist.checkpoint.controllers;

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

import fr.songlist.checkpoint.entities.Song;
import fr.songlist.checkpoint.repositories.SongRepository;

@RestController
@CrossOrigin(origins = "*")
public class SongController {
	
	@Autowired
	SongRepository songRepository;
	
	//List all songs
	@GetMapping(value="/songs")
	public List<Song> getSongs() throws Exception {
		try {
			return songRepository.findAll();
		} catch(Exception e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"No array of songs found"
					);
		}	
	}
	
	//Get a song with id
	@GetMapping(value="/songs/{id}")
	public Song getSong(@PathVariable("id") Long p_id) throws Exception {
		try {
			return songRepository.findById(p_id).get();
		} catch(Exception e) {
			throw new ResponseStatusException(
					HttpStatus.FORBIDDEN,
					"Forbidden"
					);
		}
	}
	
	//Create new song
	@PostMapping(value="/songs")
	public Song postSong(@RequestBody Song p_song) throws Exception {
		try {
			if(
				p_song.getName() != null &&
				p_song.getArtist() != null &&
				p_song.getAlbum() != null &&
				p_song.getImg() != null
			) {
				return songRepository.save(p_song);
			} else {
				throw new ResponseStatusException(
						HttpStatus.FORBIDDEN,
						"Forbidden"
					);
			}
		} catch(Exception e) {
			throw new ResponseStatusException(
					HttpStatus.FORBIDDEN,
					"Forbidden"
				);
		}
	}
	
	//Update song
	@PutMapping(value="/songs/{id}")
	public Song putSong(@PathVariable("id") Long p_id,@RequestBody Song p_song) {
		try {
			Song songToUpdate = songRepository.findById(p_id).get();
			if (p_song.getName() != null) {
				songToUpdate.setName(p_song.getName());			
			}
			if (p_song.getArtist() != null) {
				songToUpdate.setArtist(p_song.getArtist());			
			}
			if (p_song.getAlbum() != null) {
				songToUpdate.setAlbum(p_song.getAlbum());			
			}
			if (p_song.getImg() != null) {
				songToUpdate.setImg(p_song.getImg());
			}
			return songRepository.save(songToUpdate);
		
		

	} catch(Exception e) {
		throw new ResponseStatusException(
			HttpStatus.FORBIDDEN,
			"Forbidden"
		);
	}
	}
	
	//Delete a song
	@DeleteMapping(value="/songs/{id}")
	public boolean deletaSong(@PathVariable("id") Long p_id) throws Exception {
		try {
			songRepository.deleteById(p_id);
			return true;
		} catch(Exception e) {
			throw new ResponseStatusException(
					HttpStatus.FORBIDDEN,
					"Forbidden"
				);
			}
	}
		
	
	

}
