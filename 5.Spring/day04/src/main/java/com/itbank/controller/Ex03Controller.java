package com.itbank.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.repository.MemberDAO;
import com.itbank.repository.MemberDTO;

@Controller
@RequestMapping("/ex03")
public class Ex03Controller {
	
	private MemberDAO memberDAO;
	@Autowired
	public Ex03Controller(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@GetMapping
	public String ex03() {
		return "/ex03/login";
	}
	
	@PostMapping("/post1")
	public ModelAndView post1() {
		ModelAndView mav = new ModelAndView("/ex03/login");
		return mav;
	}
	
	@PostMapping("/post2")
	public ModelAndView post2(@RequestParam HashMap<String, String> map) {
		ModelAndView mav = new ModelAndView("/ex03/login");
		MemberDTO login = memberDAO.login2(map);
		mav.addObject("login", login);
		return mav;
	}

	@PostMapping("/post3")
	public ModelAndView post3(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("/ex03/login");
		MemberDTO login = memberDAO.login3(dto);
		mav.addObject("login", login);
		return mav;
	}
}
