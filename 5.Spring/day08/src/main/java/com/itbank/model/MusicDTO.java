package com.itbank.model;

public class MusicDTO {
	
	private int id;
	private int artist_id;
	private int album_id;
	private String name;
	private String genre;
	private int playTime;
	private String lyrics;
	private int isTitle;
	
	private String artist_name;		// 조인으로 같이 불러올 아티스트의 이름
	private String albun_name;
	
	
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

	public int getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getPlayTime() {
		return playTime;
	}
	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}
	public int getIsTitle() {
		return isTitle;
	}
	public void setIsTitle(int isTitle) {
		this.isTitle = isTitle;
	}
	
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getAlbun_name() {
		return albun_name;
	}
	public void setAlbun_name(String albun_name) {
		this.albun_name = albun_name;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
}
