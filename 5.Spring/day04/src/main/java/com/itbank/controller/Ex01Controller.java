package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.ArtistDTO;
import com.itbank.repository.ArtistDAO;

@Controller
public class Ex01Controller {
	
	
	private ArtistDAO artistDAO;
	@Autowired
	public Ex01Controller(ArtistDAO artistDAO) {
		this.artistDAO = artistDAO;
	}
	
	@GetMapping("/ex01")
	public ModelAndView ex01() {
		
		ModelAndView mav = new ModelAndView("/ex01/list");
		List<ArtistDTO> list = artistDAO.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/ex01/view")
	public ModelAndView view(int id) {
		ModelAndView mav = new ModelAndView("/ex01/view");
		ArtistDTO dto = artistDAO.selectOne(id);
		mav.addObject("dto", dto);
		return mav;
	}
}
