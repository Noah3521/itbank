package com.itbank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.AlbumDTO;

public class AlbumModifyController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		String param = request.getParameter("id");
		if(param==null) {
			return "redirect:/album";
		}
		int id = Integer.parseInt(param);
		AlbumDTO dto = albumDAO.selectOne(id);
		request.setAttribute("dto", dto);
		return "/album/modify";
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
		AlbumDTO dto = fileUtil.getAlbumDTO(request);
		int id = Integer.parseInt(request.getParameter("id"));
		dto.setId(id);
		int row = albumDAO.update(dto);
		System.out.println("\n\t" + row + "행이 업데이트 되었습니다");
		return "redirect:/album/view?id="+id;
	}
}
