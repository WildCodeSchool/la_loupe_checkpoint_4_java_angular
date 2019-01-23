package fr.songlist.checkpoint.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="songs")
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String artist;
	private String album;
	private String img;
	
	public Song() {
		
	}
	
	public Song(String name, String artist, String album, String img) {
		this.setName(name);
		this.setArtist(artist);
		this.setAlbum(album);
		this.setImg(img);
	}
	
	@Override
	public String toString() {
		return "Song [id="+id+", name="+name+", artist="+artist+", album="+album+", img="+img+"]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

}
