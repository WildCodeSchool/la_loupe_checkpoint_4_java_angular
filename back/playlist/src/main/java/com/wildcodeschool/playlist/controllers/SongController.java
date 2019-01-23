package com.wildcodeschool.playlist.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wildcodeschool.playlist.entities.Song;
import com.wildcodeschool.playlist.repositories.SongRepo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SongController {

	@Autowired
	SongRepo songRepo;

	@GetMapping("/songs")
	public List<Song> getAllSongs() {
		List<Song> songs = new ArrayList<Song>();
		songRepo.findAll().forEach(songs::add);
		return songs;
	}

	@GetMapping("/songs/{id}")
	public Song getSong(@PathVariable Long id) throws Exception {
		try {
			return songRepo.findById(id).get();
		} catch (Exception p_exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No song found for id : " + id);
		}
	}

	@PostMapping("/songs")
	public Song addSong(@RequestBody Song song) {
		return songRepo.save(song);
	}

	@PutMapping("/songs/{id}")
	public Song updateSong(@PathVariable Long id, @RequestBody Song song) throws Exception {
		try {
			Song songToUpdate = songRepo.findById(id).get();
			if (song.getName() != null) {
				songToUpdate.setName(song.getName());
			}
			if (song.getArtist() != null) {
				songToUpdate.setArtist(song.getArtist());
			}
			if (song.getAlbum() != null) {
				songToUpdate.setAlbum(song.getAlbum());
			}
			if (song.getImg() != null) {
				songToUpdate.setImg(song.getImg());
			}
			return songRepo.save(songToUpdate);

		} catch (Exception p_exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No song found for id: " + id);
		}
	}

	@DeleteMapping("/songs/{id}")
	public boolean deleteSong(@PathVariable Long id) throws Exception {
		try {
			songRepo.deleteById(id);
			return true;
		} catch (Exception p_exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No song found for id: " + id);
		}
	}

}
