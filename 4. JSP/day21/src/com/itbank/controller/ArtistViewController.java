package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.AlbumDTO;
import com.itbank.model.ArtistDTO;

public class ArtistViewController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		String param = request.getParameter("id");
		if(param==null) {
			return "redirect:/artist";
		}
		int id = Integer.parseInt(param);
		List<AlbumDTO> albumList = albumDAO.selectList(id);
		ArtistDTO artistDTO = artistDAO.selectOne(id);
		request.setAttribute("artistDTO", artistDTO);
		request.setAttribute("albumList", albumList);
		return "/artist/view";
	}
}
