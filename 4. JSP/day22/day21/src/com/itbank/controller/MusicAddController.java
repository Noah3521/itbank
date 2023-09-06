package com.itbank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.MusicDTO;

public class MusicAddController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		return "/music/add";
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
		int row = musicDAO.insert(mapping(request));
		System.out.println("\n\t" + row + "행이 추가되었습니다\n");
		return "redirect:/music/view?id=" + musicDAO.getMaxId();
	}

	private MusicDTO mapping(HttpServletRequest request) {
		MusicDTO dto = new MusicDTO();
		dto.setArtist_id(Integer.parseInt(request.getParameter("artist_id")));
		dto.setAlbum_id(Integer.parseInt(request.getParameter("album_id")));
		dto.setName(request.getParameter("name"));
		dto.setGenre(request.getParameter("genre"));
		dto.setPlaytime(Integer.parseInt(request.getParameter("playtime")));
		dto.setLyrics(request.getParameter("lyrics"));
		return dto;
	}
}
