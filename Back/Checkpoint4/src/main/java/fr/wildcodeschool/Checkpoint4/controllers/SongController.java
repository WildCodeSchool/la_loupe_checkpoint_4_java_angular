package fr.wildcodeschool.Checkpoint4.controllers;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import fr.wildcodeschool.Checkpoint4.entities.Song;
import fr.wildcodeschool.Checkpoint4.repositories.SongDAO;


@CrossOrigin(origins = "*")
@RestController
public class SongController {
	
	@Autowired
	private SongDAO dao;
	
	@GetMapping(value = "/songs")
	public List<Song> getAll() throws Exception {
		try {
			return dao.findAll();
		} catch (Exception p_exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No songs found");
		}
	}

	@GetMapping(value = "/songs/{id}")
	public Song getById(@PathVariable("id") Long p_id) throws Exception {

		try {
			return dao.findById(p_id).get();
		} catch (Exception p_exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No song found for id: " + p_id);
		}
	}

	@PostMapping("/songs")
	public Song create(@RequestBody Song p_song) {
		return dao.save(p_song);
	}
	
	@PostMapping("/songs/uploadImage")
	public boolean uploadImage(@RequestParam MultipartFile imageSent) throws Exception {
		System.out.println("Dans uploadImage");

		// Si le fichier est de type image
		if (imageSent.getContentType().startsWith("image/")) {
			Song img = dao.findById((long) 1).get();
			// Veuillez changer le chemin vers le projet angular
			String path = "/home/aurelien/Documents/Checkpoint/4thCheckpoint/la_loupe_checkpoint_4_java_angular/Front/Checkpoint4/src/assets/images"
					+ imageSent.getOriginalFilename();
			System.out.println("Dans 1er If");
			try {
				System.out.println("Dans try");
				imageSent.transferTo(new File(path));
				String relativePath = path.substring(path.indexOf("src"), path.length());
				img.setImg(relativePath);
				dao.save(img);	
			} catch (IllegalStateException | IOException e) {
				throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Could not save image");
				//return false;
			}
			return true;
		} else {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Could not save image 2");
			//return false;
		}
	}

	@PutMapping("/songs/{id}")
	public Song update(@PathVariable("id") Long p_id, @RequestBody Song p_song) throws Exception {

		Song current = dao.findById(p_id).get();

		try {

			if (p_song.getName() != null) {
				current.setName(p_song.getName());
			}

			if (p_song.getArtist() != null) {
				current.setArtist(p_song.getArtist());
			}
			
			if (p_song.getAlbum() != null) {
				current.setAlbum(p_song.getAlbum());
			}
			
			if (p_song.getImg() != null) {
				current.setImg(p_song.getImg());
			}

			return dao.save(current);
		} catch (Exception p_exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No song found for id: " + p_id);
		}
	}

	@DeleteMapping("/songs/{id}")
	public boolean delete(@PathVariable("id") Long p_id) throws Exception {

		try {
			dao.deleteById(p_id);
			return true;
		} catch (Exception p_exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No song found for id: " + p_id);
		}
	}

}
