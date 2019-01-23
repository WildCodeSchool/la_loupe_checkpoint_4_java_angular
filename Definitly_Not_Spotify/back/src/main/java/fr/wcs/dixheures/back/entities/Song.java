package fr.wcs.dixheures.back.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "songs")
public class Song {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String artist;
	private String album;
	private String img;
	
	public Song() {}
	
	public Song(String name, String artist, String album, String img) {
		this.name = name;
		this.artist = artist;
		this.album = album;
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Long getId() {
		return id;
	}
	
	
}
