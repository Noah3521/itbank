package com.itbank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.MusicDTO;

public class MusicModifyController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		String param = request.getParameter("id");
		if (param==null) {
			return "redirect:/music";
		}
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("dto", musicDAO.selectOne(id));
		return "music/modify";
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
		MusicDTO dto = mapping(request);
		int row = musicDAO.update(dto);
		System.out.println("\n\t" + row + "행이 업데이트 되었습니다\n");
		return "redirect:/music/view?id=" + dto.getId();
	}
	
	private MusicDTO mapping(HttpServletRequest request) {
		MusicDTO dto = new MusicDTO();
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setArtist_id(Integer.parseInt(request.getParameter("artist_id")));
		dto.setAlbum_id(Integer.parseInt(request.getParameter("album_id")));
		dto.setName(request.getParameter("name"));
		dto.setGenre(request.getParameter("genre"));
		dto.setPlaytime(Integer.parseInt(request.getParameter("playtime")));
		dto.setLyrics(request.getParameter("lyrics"));
		return dto;
	}
}
