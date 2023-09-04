package com.itbank.model;

import java.sql.Date;

//	ID        NOT NULL NUMBER        
//	ARTIST_ID NOT NULL NUMBER        
//	NAME      NOT NULL VARCHAR2(200) 
//	TYPE      NOT NULL VARCHAR2(100) 
//	RDATE     NOT NULL DATE          
//	PLAYTIME  NOT NULL NUMBER        
//	COVERIMG           VARCHAR2(500) 

public class AlbumDTO {
	private int id;
	private int artist_id;
	private String name;
	private String type;
	private Date rdate;
	private int playtime;
	private String coverimg;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public int getPlaytime() {
		return playtime;
	}
	public void setPlaytime(int playtime) {
		this.playtime = playtime;
	}
	public String getCoverimg() {
		return coverimg;
	}
	public void setCoverimg(String coverimg) {
		this.coverimg = coverimg;
	}
}
