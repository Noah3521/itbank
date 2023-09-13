package com.itbank.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.ArtistDTO;
import com.itbank.repository.ArtistDAO;

@Controller
@RequestMapping("/ex02")
public class Ex02Controller {
	
	private ArtistDAO artistDAO;
	public Ex02Controller(ArtistDAO artistDAO) {
		this.artistDAO = artistDAO;
	}
	
	@GetMapping
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/ex02/list");
		List<ArtistDTO> list = artistDAO.selectAll();
		mav.addObject("list", list);
		return mav; 
	}
	
	//@GetMapping("/board/{boardCategory}/{boardId}/")
	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("/ex02/view");
		ArtistDTO dto = artistDAO.selectOne(id);
		mav.addObject("dto", dto);
		return mav;
	}
}
