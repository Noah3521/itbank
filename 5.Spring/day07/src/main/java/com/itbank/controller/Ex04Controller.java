package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
public class Ex04Controller {
	
	@Autowired private MemberDAO memberDAO;
	@Autowired private HashComponent hashComponent;
	
	@GetMapping("/ex04") 
	public String ex04() {
		return "/ex04";
	}
	
	@PostMapping("/ex04") 
	public ModelAndView ex04(String currentPW, String newPW, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("alter");
		
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		
		if(login==null) {
			mav.setViewName("redirect:/ex02");
			return mav;
		}
		
		MemberDTO member = memberDAO.selectOneByUserid(login.getUserid());
		
		if (!member.getUserpw().equals(hashComponent.getHash(currentPW, member.getSalt()))) {
			mav.setViewName("redirect:/ex04");
			return mav;
		}
		
		
		String salt = hashComponent.getRandomSalt();
		String hash = hashComponent.getHash(newPW, salt);
		
		login.setUserpw(hash);	
		login.setSalt(salt);
		
		mav.addObject("msg", "변경된 비밀번호는 [" + newPW + "] 입니다");
		mav.addObject("url", "/ex02");

		int row = memberDAO.updatePass(login); // 비밀번호 변경
		System.out.println(row + "행 비밀번호 변경 완료");
		
		session.invalidate(); // 세션 초기화
		
		return mav;
	}
	
}
