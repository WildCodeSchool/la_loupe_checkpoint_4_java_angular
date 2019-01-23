package com.wildcodeschool.checkpoint.main.controller;

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

import com.wildcodeschool.checkpoint.main.entites.Chanson;
import com.wildcodeschool.checkpoint.main.repositories.ChansonDAO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/chanson")
public class ChansonController {

	@Autowired
	private ChansonDAO dao;
	
	@GetMapping("/")
	public List<Chanson> getAll() {
		return this.dao.findAll();
	}
	
	@GetMapping("/{id}")
	public Chanson getById(@PathVariable Long id) {
		return this.dao.findById(id).get();
	}
	
	@PostMapping("/")
	public void add(@RequestBody Chanson chanson) throws Exception {
		this.dao.save(chanson);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody Chanson chanson) throws Exception {
		Chanson ch = this.dao.findById(id).get();
		
		if (!chanson.getAlbum().isEmpty()) {
			ch.setAlbum(chanson.getAlbum());
		}
		
		if (!chanson.getArtist().isEmpty()) {
			ch.setArtist(chanson.getArtist());
		}
		
		if (!chanson.getImg().isEmpty()) {
			ch.setImg(chanson.getImg());
		}
		
		if (!chanson.getName().isEmpty()) {
			ch.setName(chanson.getName());
		}
		
		this.dao.save(ch);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) throws Exception {
		this.dao.deleteById(id);
	}
}
