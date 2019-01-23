package fr.checkpoint.back.controllers;

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

import fr.checkpoint.back.entities.Song;
import fr.checkpoint.back.repository.SongRepository;

@CrossOrigin(origins= {"*"})
@RestController
public class SongController {

	@Autowired
	SongRepository songRepository;
	
	@GetMapping( "song/all" )
	public List<Song> index() throws Exception{
		try {
			return songRepository.findAll();
		} catch( Exception param_exception) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"No song found"
					);
		}
	}
	
	@GetMapping( "song/{id}" )
	public Song show( @PathVariable("id") Long param_id) throws Exception {
		try {
			return songRepository.findById(param_id).get();
		} catch( Exception param_exception ) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"no song found for id: " + param_id
					);
			}
	}
	
//	###############################################################################################
	@PostMapping("song")
	public Song create( @RequestBody Song song) throws Exception{
		try {
			if( song.getAlbum() != "" && song.getArtist() != ""  
				&& song.getName() != "" && song.getImg() != ""
				&& song.getAlbum() != null && song.getArtist() != null  
				&& song.getName() != null && song.getImg() != null)  
			{
				return songRepository.save(song);
			}else {
				throw new ResponseStatusException(
						HttpStatus.BAD_REQUEST,
						"no field should be empty"
						);
			}
		} catch( Exception param_exception) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST,
					"no field should be empty"
					);
		}
		
	}
	
//	#################################################################################################
    @PutMapping("song/{id}")
    public Song update(@PathVariable("id") Long param_id, @RequestBody Song param_Song) 
		throws Exception {
    	
    	try {
	    	return songRepository.save(param_Song);
    	}
    	catch( Exception param_exception ) {
    		throw new ResponseStatusException(
	          HttpStatus.NOT_FOUND, 
	          "no Song found for id: " + param_id
    		);
    	}
    }
//	######################################################################################################
    @DeleteMapping("song/{id}")
    public boolean delete(@PathVariable("id") Long param_id) throws Exception {
    	
    	try {
    		songRepository.deleteById(param_id);
        	return true;
    	}
    	catch( Exception param_exception ) {
    		throw new ResponseStatusException(
	          HttpStatus.NOT_FOUND, 
	          "no Song found for id: " + param_id
    		);
    	}
    	
    	
    }

}
