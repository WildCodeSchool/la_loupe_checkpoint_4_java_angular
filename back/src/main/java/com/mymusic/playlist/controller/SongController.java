package com.mymusic.playlist.controller;

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

import com.mymusic.playlist.entities.Song;
import com.mymusic.playlist.repository.SongRepository;

@CrossOrigin( origins="*")
@RestController
public class SongController {
	
	@Autowired
	private SongRepository songRepo;
	
	@GetMapping("/songs")
	public List<Song> index() {
	    return songRepo.findAll();
	}
	
	@GetMapping("/songs/{id}")
    public Song show(@PathVariable int p_id){
		try {
			return songRepo.findById((long) p_id).get();
    	}
    	catch( Exception p_exception ) {
    		throw new ResponseStatusException(
	          HttpStatus.NOT_FOUND, 
	          "no question found for id: " + p_id
    		);
    	}
        
    }
	
	@PostMapping("/songs")
    public Song create(@RequestBody Song p_song){
        return songRepo.save(p_song);
    }
	
	@PutMapping("/songs/{id}")
    public Song update(
    		@PathVariable("id") Long p_id, 
    		@RequestBody Song p_song
    ) throws Exception 
    {
    	
    	try {
    		Song current = songRepo.findById(p_id).get();
	    	if( p_song.getName() != null ) {
	    		current.setName(p_song.getName());
	    	}

	    	if( p_song.getArtist() != null ) {
	    		current.setArtist(p_song.getArtist());
	    	}
	    	
	    	if( p_song.getAlbum() != null ) {
	    		current.setAlbum(p_song.getAlbum());
	    	}

	    	if( p_song.getImg() != null ) {
	    		current.setImg(p_song.getImg());
	    	}
	    	
	    	return songRepo.save(current);
    	}
    	catch( Exception p_exception ) {
    		throw new ResponseStatusException(
	          HttpStatus.NOT_FOUND, 
	          "no sponsor found for id: " + p_id
    		);
    	}
    }
	
	@DeleteMapping("songs/{id}")
    public boolean delete(@PathVariable int id){
    	
    	try {
    		songRepo.deleteById((long) id);
            return true;
    	}
    	catch( Exception p_exception ) {
    		throw new ResponseStatusException(
	          HttpStatus.NOT_FOUND, 
	          "no sponsor found for id: " + id
    		);
    	}
    }
}
