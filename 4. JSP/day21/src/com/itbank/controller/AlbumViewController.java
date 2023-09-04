package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.AlbumDTO;

public class AlbumViewController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		String param = request.getParameter("id");
		if(param==null) {
			return "redirect:/album";
		}
		AlbumDTO dto = albumDAO.selectOne(Integer.parseInt(param));
		request.setAttribute("dto", dto);
		return "/album/view";
	}
}
