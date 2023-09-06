package com.itbank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.repository.AlbumDAO;
import com.itbank.repository.ArtistDAO;
import com.itbank.repository.MusicDAO;
import com.itbank.util.FileUtil;

public class Controller {
	
	protected ArtistDAO artistDAO = ArtistDAO.getInstance(); 
	protected AlbumDAO albumDAO = AlbumDAO.getInstance(); 
	protected FileUtil fileUtil = FileUtil.getInstance();
	protected MusicDAO musicDAO = MusicDAO.getInstance();
	
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		return null;
	}
	
	public String doPost(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
		return null;
	}
	
}
