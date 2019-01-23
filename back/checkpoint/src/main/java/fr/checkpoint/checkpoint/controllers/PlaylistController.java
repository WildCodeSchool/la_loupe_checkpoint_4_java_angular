package fr.checkpoint.checkpoint.controllers;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

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

import fr.checkpoint.checkpoint.entities.Playlist;
import fr.checkpoint.checkpoint.repositories.PlaylistRepository;

@CrossOrigin (origins="*")
@RestController
public class PlaylistController {
	
	@Autowired
	PlaylistRepository PlayRepo;
	
	@GetMapping ("/playlist")
	public List<Playlist> getAll(){
		return PlayRepo.findAll();
	}
	
	@GetMapping("/playlist/{id}")
	public Playlist getById(@PathVariable ("id") Long p_id) throws Exception {
		
		try {
			return PlayRepo.findById(p_id).get();
		}
		catch (Exception p_e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, 
					"aucune playlist" + p_id);
		}
	}
	
	@PostMapping("/playlist")
	public Playlist create(@RequestBody Playlist p_play) {
		return PlayRepo.save(p_play);
	}
	
	@PutMapping("/playlist/{id}")
	public Playlist update(@PathVariable("id") Long p_id, 
			@RequestBody Playlist p_play) throws Exception {
		
		try {
			Playlist current = PlayRepo.findById(p_id).get();
			if (p_play.getName() != "" && p_play.getName() != null) {
				current.setName(p_play.getName());
			}			
			if (p_play.getArtist() !="" && p_play.getArtist() != null) {
				current.setArtist(p_play.getArtist());
			}
			if (p_play.getAlbum() !="" && p_play.getAlbum() != null) {
				current.setAlbum(p_play.getAlbum());
			}
			if (p_play.getImg() !="" && p_play.getImg() != null) {
				current.setImg(p_play.getImg());
			}
			return PlayRepo.save(current);
		}
		catch (Exception p_e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"pas de playlist" + p_id);
		}
	}
	
	@DeleteMapping("/playlist/{id}")
	public boolean delete(@PathVariable("id") Long p_id) throws Exception {
		try {
			PlayRepo.deleteById(p_id);
			return true;
			}
		catch (Exception p_e) {
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND,
					"pas de playlist" +p_id );
		}
	}

}
