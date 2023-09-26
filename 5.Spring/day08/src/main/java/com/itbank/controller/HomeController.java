package com.itbank.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("date", new Date());
		return mav;
	}

	
}
