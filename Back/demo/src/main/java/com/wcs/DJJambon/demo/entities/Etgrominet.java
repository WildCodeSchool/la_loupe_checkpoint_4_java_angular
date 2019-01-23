package com.wcs.DJJambon.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discodocs")

public class Etgrominet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String song;
	private String singerName;
	private String record;
	private String recordPicture;
	
	public Etgrominet() {  }

    public Etgrominet(Long id, String song,String singerName, String record,String recordPicture) {
        this.setId(id);
        this.setSong(song);
        this.setSingerName(singerName);
        this.setRecord(record);
        this.setRecord(recordPicture);
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public String getRecordPicture() {
		return recordPicture;
	}
	public void setRecordPicture(String recordPicture) {
		this.recordPicture = recordPicture;
	}

	
}



