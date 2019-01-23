package fr.wcs.dixheures.back.controllers;

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

import fr.wcs.dixheures.back.entities.Song;
import fr.wcs.dixheures.back.repositories.SongRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/dixheures/api")
@RestController
public class SongPlaylist {
	
	@Autowired
	SongRepository songRepo;
	
	// :+:+:+:+:+:
	// Song API
	// :+:+:+:+:+:
	
	@GetMapping("/songs")
	public List<Song> songList() throws Exception {
		try {
			return songRepo.findAll();
		} catch(Exception oups) {
			throw new ResponseStatusException(
					HttpStatus.I_AM_A_TEAPOT,
					"C'est pas l'heure du café !");
		}
	}
	
	@GetMapping("/songs/{id}")
	public Song getTune(@PathVariable Long id) throws Exception {
		try {
			return songRepo.findById(id).get();
		} catch(Exception oups) {
			throw new ResponseStatusException(
					HttpStatus.I_AM_A_TEAPOT,
					"C'est pas l'heure du café !");
		}
	}
	
	@PostMapping("/songs")
	public Song addTune(@RequestBody Song incoming) throws Exception {
		try {
			Song aNewOne = new Song(
						incoming.getName(),
						incoming.getArtist(),
						incoming.getAlbum(),
						incoming.getImg()
					);
			
			return songRepo.save(aNewOne);	
		} catch(Exception oups) {
			throw new ResponseStatusException(
					HttpStatus.I_AM_A_TEAPOT,
					"C'est pas l'heure du café !");
		}
	}
	
	@PutMapping("/songs/{id}")
	public Song rectifyTune(@RequestBody Song incoming, @PathVariable Long id) {
		try {
			Song toBeModified = songRepo.findById(id).get();
			
			if(incoming.getName() != null) toBeModified.setName( incoming.getName());
			if(incoming.getArtist() != null) toBeModified.setArtist( incoming.getArtist());
			if(incoming.getAlbum() != null) toBeModified.setAlbum( incoming.getAlbum());
			if(incoming.getImg() != null) toBeModified.setImg( incoming.getImg());
			
			return songRepo.save(toBeModified);
		} catch(Exception oups) {
			throw new ResponseStatusException(
					HttpStatus.I_AM_A_TEAPOT,
					"C'est pas l'heure du café !");
		}
	}
	
	@DeleteMapping("/songs/{id}")
	public boolean removeTune(@PathVariable Long id) {
		try {
			songRepo.deleteById(id);
			return true;
		} catch(Exception oups) {
			throw new ResponseStatusException(
					HttpStatus.I_AM_A_TEAPOT,
					"C'est pas l'heure du café !");
		}
	}
	
	
	// :+:+:+:+:+:+:
	// Playlist API
	// :+:+:+:+:+:+:
	
//	@GetMapping("/playlists")
//	public List<Playlist> getPlaylists() {
//		try {
//			return plRepo.findAll();
//		} catch(Exception oups) {
//			throw new ResponseStatusException(
//					HttpStatus.I_AM_A_TEAPOT,
//					"C'est pas l'heure du café !");
//		}
//	}
//	
//	@GetMapping("/playlists/{id}")
//	public Playlist getAPlaylist(@PathVariable Long id) {
//		try {
//			return plRepo.findById(id).get();
//		} catch(Exception oups) {
//			throw new ResponseStatusException(
//					HttpStatus.I_AM_A_TEAPOT,
//					"C'est pas l'heure du café !");
//		}
//	}
//	
//	@PostMapping("/playlists")
//	public Playlist newPlaylist(@RequestBody Playlist incoming) throws Exception {
//		try {
//			if(incoming.getName() == null) throw new ResponseStatusException(
//					HttpStatus.I_AM_A_TEAPOT,
//					"C'est pas l'heure du café !");
//			
//			Playlist aNewOne = new Playlist(
//						incoming.getName()
//					);
//			
//			return plRepo.save(aNewOne);
//		} catch(Exception oups) {
//			throw new ResponseStatusException(
//					HttpStatus.I_AM_A_TEAPOT,
//					"C'est pas l'heure du café !");
//		}
//	}
//	
//	@PutMapping("/playlists/{id}")
//	public Playlist PlaylistModifyName(@RequestBody Playlist incoming, @PathVariable Long id) {
//		try {
//			Playlist toBeModified = plRepo.findById(id).get();
//			
//			if(incoming.getName() != null) toBeModified.setName( incoming.getName() );
//			
//			return plRepo.save(toBeModified);
//		} catch(Exception oups) {
//			throw new ResponseStatusException(
//					HttpStatus.I_AM_A_TEAPOT,
//					"C'est pas l'heure du café !");
//		}
//	}
//	
//	@PutMapping("/playlists/{list}/{song}")
//	public Playlist addSongToList(@PathVariable Long list, @PathVariable Long song) {
//		try {
//			Song toBeAdded = songRepo.findById(song).get();
//			Playlist toBeModified = plRepo.findById(list).get();
//			
//			List <Song> alteredList = toBeModified.getSongs();
//			alteredList.add(toBeAdded);
//			toBeModified.setSongs(alteredList);
//			plRepo.save(toBeModified);
//			
//			toBeAdded.setPlaylist(toBeModified);
//			songRepo.save(toBeAdded);
//			
//			return plRepo.findById(list).get();
//			
//		} catch(Exception oups) {
//			throw new ResponseStatusException(
//					HttpStatus.I_AM_A_TEAPOT,
//					"C'est pas l'heure du café !");
//		}
//	}
}
