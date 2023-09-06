package com.itbank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.ArtistDTO;

public class ArtistModifyController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		String param = request.getParameter("id");
		if(param==null) {
			return "redirect:/artist";
		}
		int id = Integer.parseInt(param);
		ArtistDTO dto = artistDAO.selectOne(id);
		request.setAttribute("dto", dto);
		return "/artist/modify";
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
		ArtistDTO dto = fileUtil.getArtistDTO(request);
		int id = Integer.parseInt(request.getParameter("id"));
		dto.setId(id);
		int row = artistDAO.update(dto);
		System.out.println("\n\t" + row + "행이 업데이트 되었습니다");
		return "redirect:/artist/view?id="+id;
	}
}
