package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.repository.MemberDAO;
import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;

@Controller
public class Ex01Controller {
	
	@Autowired private HashComponent hashComponent;
	@Autowired private MemberDAO memberDAO;
	
	@GetMapping("/ex01")
	public void ex01() {}
	
	@PostMapping("/ex01")
	public String ex01(MemberDTO dto) {
		String salt = hashComponent.getRandomSalt();
		String hash = hashComponent.getHash(dto.getUserpw(), salt);
		dto.setSalt(salt);
		dto.setUserpw(hash);
		int row = memberDAO.insert(dto);
		System.out.println(row + "행 추가");
		return "redirect:/";
	}
	
}
