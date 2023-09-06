package com.itbank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.ArtistDTO;

public class ArtistAddController extends Controller{
	
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		return "/artist/add";
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
		ArtistDTO dto = fileUtil.getArtistDTO(request);
		int row = artistDAO.insert(dto);
		System.out.println("\n\t" + row + "행이 추가되었습니다");
		return "redirect:/artist/view?id=" + artistDAO.getMaxId();
	}
}
