package com.itbank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.AlbumDTO;

public class AlbumAddController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		return "/album/add";
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
		AlbumDTO dto = fileUtil.getAlbumDTO(request);
		int row = albumDAO.insert(dto);
		System.out.println("\n\t" + row + "행이 삽입되었습니다");
		return "redirect:/album/view?id=" + albumDAO.getMaxId();
	}
}
