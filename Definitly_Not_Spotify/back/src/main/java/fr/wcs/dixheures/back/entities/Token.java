package fr.wcs.dixheures.back.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.wcs.dixheures.back.Encryption;

@Entity
@Table(name = "tokens")
public class Token {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
	
	private String token;
	private Date expirancy;
	
	@OneToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
	
	public Token() { }
	
	public Token(Date expirancy) {
		this.token = Encryption.genToken();
		this.expirancy = expirancy;
	}
	
	public Token(Date expirancy, String key) {
		this.expirancy = expirancy;
		this.token = key;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpirancy() {
		return expirancy;
	}

	public void setExpirancy(Date expirancy) {
		this.expirancy = expirancy;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}
}
