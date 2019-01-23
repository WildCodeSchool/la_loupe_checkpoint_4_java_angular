package com.wildcodeschool.checkpoint.wcs.controller;

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

import com.wildcodeschool.checkpoint.wcs.entity.Music;
import com.wildcodeschool.checkpoint.wcs.repository.MusicRepository;


@RestController
@CrossOrigin(origins = "*")
public class MusicController {
	
	@Autowired
	MusicRepository musicRepository;
	
	
	// List all the musics
	@GetMapping(value="/musics")
	public List<Music> getMusics() throws Exception {
		try {
			return musicRepository.findAll();
		} catch(Exception e) {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND,
				"No array of musics found"
			);
		}
	}
	
	// Get a music with its id
		@GetMapping(value="/musics/{id}")
		public Music getMusic(@PathVariable("id") Long p_id) throws Exception {
			try {
				return musicRepository.findById(p_id).get();
				
			} catch(Exception e) {
				throw new ResponseStatusException(
					HttpStatus.FORBIDDEN,
					"Forbidden"
				);
			}
		}
		
		// Create and save a new music
		@PostMapping(value="/musics")
		public Music postMusic(@RequestBody Music p_music) throws Exception {
			try {
				if (
					p_music.getName() != null	&&				
					p_music.getArtist() != null &&
					p_music.getAlbum() != null &&
					p_music.getImg() != null
				) {
					return musicRepository.save(p_music);
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
		
		// Update a music
		@PutMapping(value="/musics/{id}")
		public Music putMusic(@PathVariable("id") Long p_id, @RequestBody Music p_music) {
			try {
				// Get the music to update
				Music musicToUpdate = musicRepository.findById(p_id).get();			
				if (p_music.getName() != null) {
					musicToUpdate.setName(p_music.getName());			
				}
				if (p_music.getArtist() != null) {
					musicToUpdate.setArtist(p_music.getArtist());			
				}
				if (p_music.getAlbum() != null) {
					musicToUpdate.setAlbum(p_music.getAlbum());			
				}
				if (p_music.getImg() != null) {
					musicToUpdate.setImg(p_music.getImg());
				}
				return musicRepository.save(musicToUpdate);

			} catch(Exception e) {
				throw new ResponseStatusException(
					HttpStatus.FORBIDDEN,
					"Forbidden"
				);
			}
		}
		// Delete a music with its id
		@DeleteMapping(value="/musics/{id}")
		public boolean deleteMassage(@PathVariable("id") Long p_id) throws Exception {
			try {
				musicRepository.deleteById(p_id);
				return true;
				
			} catch(Exception e) {
				throw new ResponseStatusException(
					HttpStatus.FORBIDDEN,
					"Forbidden"
				);
			}
		}

}
