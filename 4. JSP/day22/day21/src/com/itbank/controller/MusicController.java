package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.MusicDTO;

public class MusicController extends Controller {
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse httpServletResponse) {
		List<MusicDTO> musicList = musicDAO.selectList();
		request.setAttribute("musicList", musicList);
		return "/music/list";
	}
}
