package com.eTunes.eTunes.controller;

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

import com.eTunes.eTunes.entities.Song;
import com.eTunes.eTunes.repository.SongRepository;


@CrossOrigin( origins="*")
@RestController
public class SongController {
	
	@Autowired
	SongRepository SongRepo;


	
	@GetMapping("/songs")
    public List<Song> index(){
        return SongRepo.findAll();
    }
	
	@PostMapping("/songs")
    public Song create(@RequestBody Song p_song){
		
        return SongRepo.save(p_song);
    }
	
    @PutMapping("/songs/{id}")
    public Song update(
    		@PathVariable("id") Long p_id, 
    		@RequestBody Song p_song
    ) throws Exception 
    {
    	
    	try {
    		Song current = SongRepo.findById(p_id).get();
	    	if( p_song.getName() != null ) {
	    		current.setName(p_song.getName());
	    	}
	    	
	    	if( p_song.getImg() != null ) {
	    		current.setImg(p_song.getImg());
	    	}
	    	
	    	if( p_song.getArtist() != null ) {
	    		current.setArtist(p_song.getArtist());
	    	}
	    	
	    	if( p_song.getAlbum() != null ) {
	    		current.setAlbum(p_song.getAlbum());
	    	}
	    	
	    	return SongRepo.save(current);
    	}
    	catch( Exception p_exception ) {
    		throw new ResponseStatusException(
	          HttpStatus.NOT_FOUND, 
	          "no song found for id: " + p_id
    		);
    	}
    }
    
    @DeleteMapping("songs/{id}")
    public boolean delete(@PathVariable int id){
    	
    	try {
    		SongRepo.deleteById((long) id);
            return true;
    	}
    	catch( Exception p_exception ) {
    		throw new ResponseStatusException(
	          HttpStatus.NOT_FOUND, 
	          "no song found for id: " + id
    		);
    	}
    }

}
