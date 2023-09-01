package com.itbank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

public class BoardViewController implements Controller {
	
	private BoardDAO dao = BoardDAO.getInstance();
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("idx");
		if(param == null) {
			return "redirect:/board";
		}
		int idx = Integer.parseInt(param);
		BoardDTO dto = dao.selectOne(idx);
		request.setAttribute("dto", dto);
		return "view";
	}

	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
}
