package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
public class Ex02Controller {
	
	@Autowired private MemberDAO memberDAO;
	@Autowired private HashComponent hashComponent;
	
	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public String ex02(MemberDTO param, HttpSession session) {
		MemberDTO login = memberDAO.selectOneByUserid(param.getUserid());
		if(login==null) {
			session.invalidate();
			return "redirect:/ex02";
		}
		String hash = hashComponent.getHash(param.getUserpw(), login.getSalt());
		if(! hash.equals(login.getUserpw())) {
			session.invalidate();
			return "redirect:/ex02";
		} 
		session.setAttribute("login", login);
		return "redirect:/";
	}
	
}
