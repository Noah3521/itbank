package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.ArtistDTO;

public class ArtistController extends Controller {
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		List<ArtistDTO> list = artistDAO.selectList();
		request.setAttribute("list", list);
		return "/artist/list";
	}

}
