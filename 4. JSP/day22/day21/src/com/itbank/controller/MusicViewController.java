package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.AlbumDTO;
import com.itbank.model.ArtistDTO;
import com.itbank.model.MusicDTO;

public class MusicViewController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		String param = request.getParameter("id");
		if(param==null) {
			return "redirect:/music";
		}
		int id = Integer.parseInt(param);
		MusicDTO musicDTO = musicDAO.selectOne(id);
		AlbumDTO albumDTO = albumDAO.selectOne(musicDTO.getAlbum_id());
		ArtistDTO artistDTO = artistDAO.selectOne(musicDTO.getArtist_id());
		request.setAttribute("musicDTO", musicDTO);
		request.setAttribute("albumDTO", albumDTO);
		request.setAttribute("artistDTO", artistDTO);
		return "/music/view";
	}
}
