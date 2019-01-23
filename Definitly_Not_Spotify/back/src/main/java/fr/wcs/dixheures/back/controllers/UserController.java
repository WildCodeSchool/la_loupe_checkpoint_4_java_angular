package fr.wcs.dixheures.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.wcs.dixheures.back.Encryption;
import fr.wcs.dixheures.back.entities.User;
import fr.wcs.dixheures.back.repositories.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/dixheures/api")
@RestController
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@PostMapping("/users")
	public User createUser(@RequestBody User incoming) throws Exception {
		try {
			User newUser = new User(
						incoming.getName(),
						incoming.getEmail(),
						incoming.getPassword()
					);
			
			return repo.save(newUser);
		} catch(Exception oups) {
			throw new ResponseStatusException(
					HttpStatus.I_AM_A_TEAPOT,
					"C'est pas l'heure du café !");
		}
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User incoming, @PathVariable Long id) throws Exception  {
		try {
			User toBeModified = repo.findById(id).get();
			
			if(incoming.getName() != null) toBeModified.setName(incoming.getName());
			if(incoming.getEmail() != null) toBeModified.setEmail(incoming.getEmail());
			
			return repo.save(toBeModified);
		} catch(Exception oups) {
			throw new ResponseStatusException(
					HttpStatus.I_AM_A_TEAPOT,
					"C'est pas l'heure du café !");
		}
	}
	
	@PutMapping("/users")
	public User passwordChange(
			@RequestBody String name,
			@RequestBody String password,
			@RequestBody String newPassword) throws Exception  {
		try {
			User toBeModified = repo.findByNameAndPassword(name, Encryption.genPasswd(password));
			
			if(newPassword != null) toBeModified.setPassword(Encryption.genPasswd(newPassword));
			
			return repo.save(toBeModified);
		} catch(Exception oups) {
			throw new ResponseStatusException(
					HttpStatus.I_AM_A_TEAPOT,
					"C'est pas l'heure du café !");
		}
	}
	
	@DeleteMapping("/users/{id}")
	public boolean deleteUser(@PathVariable Long id) throws Exception {
		try {
			repo.deleteById(id);
			return true;
		} catch(Exception oups) {
			throw new ResponseStatusException(
					HttpStatus.I_AM_A_TEAPOT,
					"C'est pas l'heure du café !");
		}
	}
}