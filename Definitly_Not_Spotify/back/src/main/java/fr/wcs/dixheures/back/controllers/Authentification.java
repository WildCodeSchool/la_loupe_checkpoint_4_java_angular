package fr.wcs.dixheures.back.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import fr.wcs.dixheures.back.Encryption;
import fr.wcs.dixheures.back.entities.Token;
import fr.wcs.dixheures.back.entities.User;
import fr.wcs.dixheures.back.repositories.TokenRepository;
import fr.wcs.dixheures.back.repositories.UserRepository;

public class Authentification {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TokenRepository tokenRepo;

	@SuppressWarnings("deprecation")
	@PostMapping("/auth")
	public User authentify(@RequestBody String name, @RequestBody String password) throws Exception {
		try {
			User identified = userRepo.findByNameAndPassword(name, Encryption.genPasswd(password));
			
			if(identified.getToken() != null)  tokenRepo.delete(identified.getToken());
			
			Date expirancy = new Date();
			expirancy.setMinutes(expirancy.getMinutes() + 5);
			Token toBeAdded = new Token(expirancy);
			
			identified.setToken(toBeAdded);
			toBeAdded.setUser(identified);
			tokenRepo.save(toBeAdded);
			
			return userRepo.save(identified);
		} catch(Exception oups) {
			throw new ResponseStatusException(
					HttpStatus.I_AM_A_TEAPOT,
					"C'est pas l'heure du café !");
		}
	}
	
	
}
