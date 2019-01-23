package com.eTunes.eTunes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "songs")
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String artist;
	private String album;
	private String img;
	private boolean updateButton;
	
	
	public Song() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
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

	public boolean isUpdateButton() {
		return updateButton;
	}

	public void setUpdateButton(boolean updateButton) {
		this.updateButton = updateButton;
	}

}
