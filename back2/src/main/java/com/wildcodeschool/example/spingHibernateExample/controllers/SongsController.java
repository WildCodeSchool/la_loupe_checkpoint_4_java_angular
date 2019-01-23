package com.wildcodeschool.example.spingHibernateExample.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wildcodeschool.example.spingHibernateExample.entities.Songs;
import com.wildcodeschool.example.spingHibernateExample.repository.SongsRepository;


@RestController
public class SongsController {
	
	@Autowired
    SongsRepository songsRespository;

    @GetMapping("/songs")
    public List<Songs> index(){
        return songsRespository.findAll();
    }

    @GetMapping("/songs/{id}")
    public Songs show(@PathVariable int id){
        return songsRespository.findById(id).get();
    }

    @PostMapping("/songs/search")
    public List<Songs> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return ((SongsRepository) songsRespository).findByNameContainingOrArtistContainingOrAlbumContainingOrImgContaining(searchTerm, searchTerm, searchTerm);
    }

    @PostMapping("/songs")
    public Songs create(@RequestBody Songs songs){
        return songsRespository.save(songs);
    }

    @PutMapping("/songs/{id}")
    public Songs update(@PathVariable int id, @RequestBody Songs songs){
        // getting songs
        Songs songsToUpdate = songsRespository.findById(id).get();
        songsToUpdate.setName(songs.getName());
        songsToUpdate.setArtist(songs.getArtist());
        songsToUpdate.setAlbum(songs.getAlbum());
        songsToUpdate.setImg(songs.getImg());
        return songsRespository.save(songsToUpdate);
    }

    @DeleteMapping("songs/{id}")
    public boolean delete(@PathVariable int id){
        songsRespository.deleteById(id);
        return true;
    }

}
