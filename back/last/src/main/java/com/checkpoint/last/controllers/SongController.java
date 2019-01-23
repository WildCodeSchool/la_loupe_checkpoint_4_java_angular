package com.checkpoint.last.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkpoint.last.entities.Song;
import com.checkpoint.last.repositories.SongRepo;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class SongController {
	
	@Autowired
	SongRepo songRepo;
	
	@GetMapping("/songs")
	public List<Song> getAllSongs(){
		List<Song> songs = new ArrayList<>();
		songs = songRepo.findAll();
		
		return songs;
	}
	
	@PostMapping("/song")
	public Song create(@RequestBody Song song) {
		return songRepo.save(song);
	}
	
	@PutMapping("/song/{id}")
	public Song update(@PathVariable Long id, @RequestBody Song song) {
		Song songToUpdate = songRepo.findById(id).get();
		
		if(song.getName() != null && song.getName() != "") {
			songToUpdate.setName(song.getName());	
		}
		
		if(song.getArtist() != null && song.getArtist() != "") {
			songToUpdate.setArtist(song.getArtist());	
		}
		
		if(song.getAlbum() != null && song.getAlbum() != "") {
			songToUpdate.setAlbum(song.getAlbum());	
		}
		
		if(song.getImg() != null && song.getImg() != "") {
			songToUpdate.setImg(song.getImg());	
		}
		
		return songRepo.save(songToUpdate);
	}
	
	@DeleteMapping("/song/{id}")
	public boolean delete(@PathVariable Long id) {
		songRepo.deleteById(id);
		return true;
	}
}
