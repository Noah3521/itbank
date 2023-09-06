package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.AlbumDTO;
import com.itbank.model.ArtistDTO;
import com.itbank.model.MusicDTO;

public class AlbumViewController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		String param = request.getParameter("id");
		if(param==null) {
			return "redirect:/album";
		}
		AlbumDTO albumDTO = albumDAO.selectOne(Integer.parseInt(param));
		ArtistDTO artistDTO = artistDAO.selectOne(albumDTO.getArtist_id());
		List<MusicDTO> musicList = musicDAO.selectList(albumDTO.getId());
		request.setAttribute("albumDTO", albumDTO);
		request.setAttribute("artistDTO", artistDTO);
		request.setAttribute("musicList", musicList);
		return "/album/view";
	}
}
