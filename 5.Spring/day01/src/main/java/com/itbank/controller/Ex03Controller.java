package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.repository.Ex03DAO;

@Controller
@RequestMapping("/ex03")
public class Ex03Controller {
	
	private Ex03DAO ex03DAO;
	
	@Autowired
	public Ex03Controller(Ex03DAO ex03DAO) {
		this.ex03DAO = ex03DAO;
	}
	
	
	@GetMapping
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", ex03DAO.selectAll());
		return mav;
	}
}
