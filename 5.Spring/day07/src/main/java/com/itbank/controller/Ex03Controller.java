package com.itbank.controller;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
public class Ex03Controller {

	@Autowired MemberDAO memberDAO;
	@Autowired HashComponent hashComponent;
	
	@GetMapping("/ex03")
	public void ex03() {}
	
	@PostMapping("/ex03")
	public ModelAndView ex03(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("/alter");
		SecureRandom ran = new SecureRandom();
		byte[] arr = new byte[8];
		ran.nextBytes(arr);
		
		String salt = hashComponent.getRandomSalt();
		String pass = hashComponent.getRandomSalt().substring(1,8);
		String hash = hashComponent.getHash(pass, salt);
		
		dto.setSalt(salt);
		dto.setUserpw(hash);
		
		int row = memberDAO.updatePass(dto);
		System.out.println("\n\n\t" + row + "행 비밀번호 변경\n");
		
		System.out.println("salt : " + salt);
		System.out.println("hash : " + hash);
		System.out.println("pass : " + pass);
		
		mav.addObject("msg", String.format("신규 비밀번호는 [%s] 입니다", pass));
		mav.addObject("url", "/ex02");
		return mav;
	}
}
