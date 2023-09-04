package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.AlbumDTO;

public class AlbumController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		List<AlbumDTO> list = albumDAO.selectList();
		request.setAttribute("list", list);
		return "/album/list";
	}
}
