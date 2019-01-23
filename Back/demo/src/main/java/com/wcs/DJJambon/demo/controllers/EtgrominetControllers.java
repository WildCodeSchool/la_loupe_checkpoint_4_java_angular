package com.wcs.DJJambon.demo.controllers;

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

import com.wcs.DJJambon.demo.entities.Etgrominet;
import com.wcs.DJJambon.demo.repositories.EtgrominetDAO;



@CrossOrigin( origins="*")
@RestController
public class EtgrominetControllers {

	@Autowired
	EtgrominetDAO grosminetRepository;
	
	
	 @GetMapping( value="/Articles")
	 public  List<Etgrominet> getAll(){
	    return grosminetRepository.findAll();    
	    }
	
	 @GetMapping( value="/Articles/{id}")
	    public Etgrominet getById( @PathVariable("id") Long id ) throws Exception {
	    	
	    	try {
	    		return grosminetRepository.findById(id).get();
	    	}
	    	catch( Exception p_exception ) {
	    		throw new ResponseStatusException(
		          HttpStatus.NOT_FOUND, 
		          "dèriz nossinegue: " + id
	    		);
	    	}
	    }

	 //Update	 
	 @PutMapping("/Articles/{id}")
	    public Etgrominet update(
	    		@PathVariable("id") Long id, 
	    		@RequestBody Etgrominet Update
	    		
	    ) throws Exception 
	    {
	    	try {
	    		Etgrominet current = grosminetRepository.findById(id).get();
	    		
		    	if( Update.getSong() != null ) {
		    		current.setSong(Update.getSong());
		    	}
		    	
		    	if( Update.getSingerName() != null ) {
		    		current.setSingerName(Update.getSingerName());
		    	}
		    	if( Update.getRecord() != null ) {
		    		current.setRecord(Update.getRecord());
		    	}
		    	if( Update.getRecordPicture() != null ) {
		    		current.setRecordPicture(Update.getRecordPicture());
		    	}
		    	
		    	return grosminetRepository.save(current);
	    	}
	    	catch( Exception p_exception ) {
	    		throw new ResponseStatusException(
		          HttpStatus.NOT_FOUND, 
		          "pas d'image pour l'emplacement: " + id
	    		);
	    	}
	    }
	    
	 //create	 
	 @PostMapping("/Articles")
	    public Etgrominet create(
	    		@RequestBody Etgrominet Create
	    		
	    ) throws Exception 
	    {
	    	try {
		    	
		    	return grosminetRepository.save(Create);
	    	}
	    	catch( Exception p_exception ) {
	    		throw new ResponseStatusException(
		          HttpStatus.NOT_FOUND, 
		          "Que dalle, ca marche pas !"
	    		);
	    	}
	    }
		
	 @DeleteMapping("/Articles/{id}")
	 public boolean delete(
			 @PathVariable Long id
			 ) throws Exception {
	    	
	    	try {
	    		grosminetRepository.deleteById(id);
	        	return true;
	    	}
	    	catch( Exception p_exception ) {
	    		throw new ResponseStatusException(
		          HttpStatus.NOT_FOUND, 
		          "Impossible de supprimer "
	    		);
	    	}
	    	
	    	
	    }
	
}
