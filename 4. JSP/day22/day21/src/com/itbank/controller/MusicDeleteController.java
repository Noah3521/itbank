package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MusicDeleteController extends Controller {
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		
		String param = request.getParameter("id");
		if(param != null) {
			int id = Integer.parseInt(param);
			int row = musicDAO.delete(id);
			System.out.println("\n\t" + row + "행이 삭제되었습니다\n");
		}
		return "redirect:/music";
	}
}
